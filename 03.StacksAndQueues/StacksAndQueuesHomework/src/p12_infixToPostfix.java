import java.util.ArrayDeque;
import java.util.Scanner;

public class p12_infixToPostfix {
    static ArrayDeque<String> operatorStack = new ArrayDeque<>();
    static ArrayDeque<String> outputQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] tokens = in.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            String currentToken = tokens[i];

            if (isInteger(currentToken, 10)) {
                outputQueue.addLast(currentToken);
            } else {
                if (isOperator(currentToken)) {
                    greaterPrecedence(currentToken);
                } else { // brackets ( || )
                    if (currentToken.equals("("))
                        operatorStack.add(currentToken);
                    else {
                        toLeftBracket();
                    }
                }
            }
        }

        while (operatorStack.size() > 0) {
            outputQueue.addLast(operatorStack.removeLast());
        }

        for (String token : outputQueue) {
            System.out.print(token + " ");
        }
    }

    private static void toLeftBracket() {
        while (!operatorStack.peekLast().equals("(")) {
            outputQueue.addLast(operatorStack.removeLast());
        }

        operatorStack.removeLast();
    }

    private static void greaterPrecedence(String token) {
        if (operatorStack.size() == 0) {
            operatorStack.addLast(token);
            return;
        }

        if (token.equals("*") || token.equals("/")) {
            operatorStack.addLast(token);
            return;
        }

        while (true) {
            String operator = operatorStack.peekLast();

            if (operator.equals("(") || operator.equals(")")) {
                operatorStack.addLast(token);
                return;
            } else {
                switch (operator) {
                    case "+":
                    case "-":
                        outputQueue.addLast(operatorStack.removeLast());
                        operatorStack.addLast(token);
                        return;
                    case "*":
                    case "/":
                        outputQueue.addLast(operatorStack.removeLast());
                        break;
                }
            }
        }
    }

    private static boolean isOperator(String currentToken) {
        if (currentToken.equals("+") ||
                currentToken.equals("-") ||
                currentToken.equals("*") ||
                currentToken.equals("/")) // check - ^
            return true;

        return false;
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
