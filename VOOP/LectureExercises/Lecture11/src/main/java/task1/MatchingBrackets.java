package task1;

import java.util.*;

public class MatchingBrackets {

    public static void main(final String[] args) {
        final Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an expression with { [ ( ) ] }: ('q' to stop): ");
            final String expression = input.nextLine();

            if (expression.trim().equalsIgnoreCase("q")) return; // Guard clause. Stop execution.

            final boolean bracketsBalanced = MatchingBrackets.checkBracketsWithList(expression);

            System.out.printf("'%s' has balanced brackets: %b\n", expression, bracketsBalanced);
        }
    }



    public static boolean checkBracketsWithList(final String expression){
        List<Character> list = new ArrayList<>();
        int topIndex = -1;
        for (int i = 0; expression.length() > i; i++){
            final char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                list.add(topIndex + 1, ch);
                topIndex++;
            } else if (ch == ')' || ch == '}' || ch == ']'){
                final char top;
                try {
                    top = list.get(topIndex);
                } catch (IndexOutOfBoundsException e){
                    return false;
                }
                topIndex--;
                if (ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '['){
                    return false;
                }
            }

        }
        System.out.println(topIndex);
        return topIndex == -1;
    }



    /**
     * Method to check if a {@link String} contains equal amounts of opening/closing brackets.
     *
     * @param expression The expression to check for balanced brackets.
     * @return {@code true} If there is a balanced amount brackets.
     * {@code false} If there is not a balanced amount of brackets.
     */
    public static boolean checkBracketsWithStack(final String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; expression.length() > i; i++){
            final char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                final char top;
                try {
                    top = stack.pop();
                } catch (EmptyStackException e){
                    return false;
                }
                if (ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

