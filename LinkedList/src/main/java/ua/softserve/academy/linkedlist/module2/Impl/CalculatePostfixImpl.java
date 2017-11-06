package module2.Impl;

import java.util.List;

/**
 * Class uses for calculation postfix mathematical expression.
 */
public class CalculatePostfixImpl {
    /**
     * Method uses for calculation postfix mathematical expression.
     *
     * @param postfixExpression postfix mathematical expression written in LinkedList.
     * @return result of calculation.
     */
    public int calculate(List<String> postfixExpression) {
        StackImpl<Integer> stack = new StackImpl<>();
        for (int i = 0; i < postfixExpression.size(); i++) {
            String symbol = postfixExpression.get(i);
            switch (symbol) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(symbol));
                    break;
            }
        }
        return stack.pop();
    }
}
