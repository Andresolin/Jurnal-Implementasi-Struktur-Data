import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class InfixToPostfixConverter {
    public static String infixToPostfix(String expression) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                result += current;
            } else if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(current) <= precedence(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String infixExpression = "A+B*C";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

       
        System.out.println("\nTo-Do List:");
        Queue<String> tasks = new LinkedList<>();
        for (int i = 0; i < postfixExpression.length(); i++) {
            char current = postfixExpression.charAt(i);
            if (Character.isLetter(current)) {
                tasks.offer("Task for " + current);
            } else {
                String task2 = tasks.poll();
                String task1 = tasks.poll();
                tasks.offer(task1 + " -> " + task2 + " (Perform operation " + current + ")");
            }
        }

       
        while (!tasks.isEmpty()) {
            System.out.println(tasks.poll());
        }
    }
}
