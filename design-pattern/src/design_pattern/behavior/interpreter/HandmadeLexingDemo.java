package design_pattern.behavior.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandmadeLexingDemo {


    public static List<Token> lex(String input) {
        List<Token> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '+':
                    list.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    list.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '(':
                    list.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    list.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                default:
                    StringBuilder sb = new StringBuilder("" + input.charAt(i));
                    for (int j = i + 1; j < input.length(); j++) {
                        if (Character.isDigit(input.charAt(j))) {
                            sb.append(input.charAt(j));
                            ++i;
                        } else {
                            list.add(new Token(Token.Type.INTEGER, sb.toString()));
                            break;
                        }
                    }
                    break;
            }
        }
        return list;
    }

    static Element parse(List<Token> tokens) {
        BinaryOperation binaryOperation = new BinaryOperation();
        boolean haveLeftHandSight = false;
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            switch (token.type) {
                case INTEGER:
                    Integer integer = new Integer(java.lang.Integer.parseInt(token.text));
                    if (!haveLeftHandSight) {
                        binaryOperation.left = integer;
                        haveLeftHandSight = true;
                    } else {
                        binaryOperation.right = integer;
                    }
                    break;
                case PLUS:
                    binaryOperation.typeBinary = BinaryOperation.TypeBinary.ADDITION;
                    break;
                case MINUS:
                    binaryOperation.typeBinary = BinaryOperation.TypeBinary.SUBTRACTION;
                    break;
                case LPAREN:
                    int j = 0;
                    for (; j < tokens.size(); j++) {
                        if (tokens.get(j).type == Token.Type.RPAREN) {
                            break;
                        }
                    }
                    List<Token> subexpression = tokens.stream().skip(i + 1).limit(j - i).collect(Collectors.toList());
                    Element element = parse(subexpression);
                    if (!haveLeftHandSight) {
                        binaryOperation.left = element;
                        haveLeftHandSight = true;
                    } else {
                        binaryOperation.right = element;
                    }
                    break;
            }
        }
        return binaryOperation;
    }

    public static void main(String[] args) {
        String input = "(13+4)-(12+1)";
        List<Token> token = lex(input);
        System.out.println(token.stream().map(Token::toString).collect(Collectors.joining("\t")));
    }
}

class Token {
    public enum Type {
        INTEGER,
        PLUS,
        MINUS,
        LPAREN,
        RPAREN,
    }

    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "`" + text + "`";
    }
}

interface Element {
    int eval();
}

class Integer implements Element {

    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return 0;
    }
}

class BinaryOperation implements Element {

    public enum TypeBinary {
        ADDITION, SUBTRACTION
    }

    public TypeBinary typeBinary;

    public Element left, right;

    @Override
    public int eval() {
        switch (typeBinary) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBTRACTION:
                return left.eval() - right.eval();
            default:
                return 0;
        }
    }
}