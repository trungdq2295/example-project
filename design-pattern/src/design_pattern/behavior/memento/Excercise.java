package design_pattern.behavior.memento;

import java.util.ArrayList;
import java.util.List;

public class Excercise {

    public static void main(String[] args) {
        TokenMachine machine = new TokenMachine();
        Memento memento1 = machine.addToken(4);
        System.out.println(machine);
    }
}


class Token {
    public int value = 0;

    public Token(int value) {
        this.value = value;
    }
}

class Memento {
    public List<Token> tokens;

    public Memento(List<Token> tokens) {
        this.tokens = tokens;
    }
}

class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        Token token = new Token(value);
        tokens.add(token);
        return new Memento(tokens);
    }

    public Memento addToken(Token token) {
        tokens.add(token);
        return new Memento(tokens);
    }

    public void revert(Memento m) {
        // todo
        this.tokens = m.tokens;
    }
}
