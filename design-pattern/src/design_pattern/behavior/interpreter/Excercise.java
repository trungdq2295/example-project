package design_pattern.behavior.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Excercise {
    public static Map<Character, java.lang.Integer> variables = new HashMap<>();

    public static int calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] tokens = expression.split("[+-]");
        int result = 0;
        boolean isAddition = true;

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                int value = java.lang.Integer.parseInt(token);
                result = isAddition ? result + value : result - value;
            } else if (token.matches("[a-zA-Z]{1}") && variables.containsKey(token.charAt(0))) {
                int value = variables.get(token.charAt(0));
                result = isAddition ? result + value : result - value;
            } else {
                return 0;
            }
            // Toggle the operation (addition or subtraction) for the next token
            isAddition = expression.charAt(token.length()) == '+';
        }
        return result;
    }

    public static void main(String[] args) {
        variables.put('x',3);
        System.out.println(calculate("1+2+xy"));
        System.out.println(calculate("1+2+3"));
        System.out.println(calculate("10-2-x"));
    }

    ;
}
