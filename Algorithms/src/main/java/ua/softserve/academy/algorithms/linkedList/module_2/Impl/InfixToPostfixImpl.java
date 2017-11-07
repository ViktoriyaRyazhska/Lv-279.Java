package ua.softserve.academy.algorithms.linkedList.module_2.Impl;


import ua.softserve.academy.algorithms.linkedList.module_2.InfixToPostfix;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Class for transformation infix mathematical expression to postfix.
 * Class uses StackImpl for saving operators.
 */
public class InfixToPostfixImpl implements InfixToPostfix {
    private StackImpl<String> stack = new StackImpl<>();
    private List<String> resultPostfixExpression = new LinkedList<>();
    private List<String> infixExpression;

    /**
     * Method for transformation mathematical expression in Infix form to mathematical
     * expression in Postfix form.
     *
     * @param expression uses for receiving mathematical expression.
     * @return LinkedList that contains all operands and operators in the order of their execution
     */
    @Override
    public List<String> transfer(String expression) {
        infixExpression = transferExpressionToList(expression);

        for (int i = 0; i < infixExpression.size(); i++) {
            String symbol = infixExpression.get(i);
            switch (symbol) {
                case "+":
                case "-":
                    doAddToStack(symbol, 1);
                    break;
                case "*":
                case "/":
                    doAddToStack(symbol, 2);
                    break;
                case "(":
                    stack.push("(");
                    break;
                case ")":
                    doPopFromStack();
                    break;
                default:
                    resultPostfixExpression.add(symbol);
            }
        }
        while(!stack.isEmpty()){
            resultPostfixExpression.add(stack.pop());
        }
        return resultPostfixExpression;
    }

    /**
     * Method uses for adding operands and operators of mathematical expression
     * to LinkedList in the order of their execution.
     *
     * @param expression uses for receiving mathematical expression.
     */
    private List<String> transferExpressionToList(String expression) {
        List<String> infixExpression = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);
            switch (symbol) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '(':
                case ')':
                    infixExpression.add(builder.toString());
                    infixExpression.add(String.valueOf(symbol));
                    builder = new StringBuilder();
                    break;
                case ' ':
                    break;
                default:
                    builder.append(symbol);
            }
        }
        infixExpression.add(builder.toString());
        for(int i = 0; i < infixExpression.size(); i++){
            if(infixExpression.get(i).equals("")) {
                infixExpression.remove(i);
            }
        }
        return infixExpression;
    }

    /**
     * Method called when during parsing mathematical expression occurs ')' symbol.
     * It adds operators from the stack to the result Postfix expression.
     */
    private void doPopFromStack() {
        String symbolFromStack;
        while (!stack.isEmpty()) {
            symbolFromStack = stack.pop();
            if (Objects.equals(symbolFromStack, "(")) {
                break;
            } else {
                resultPostfixExpression.add(String.valueOf(symbolFromStack));
            }
        }
    }

    /**
     * Method called when during parsing mathematical expression occurs '+','-','*','/' symbol.
     * Depending on the priority of the operator, other operators add of remove from the stack.
     *
     * @param symbol operator from the mathematical expression
     * @param priority priority of the operator
     */
    private void doAddToStack(String symbol, int priority) {
        String symbolFromStack;
        while (!stack.isEmpty()) {
            symbolFromStack = stack.pop();
            if (Objects.equals(symbolFromStack, "(")) {
                stack.push(symbolFromStack);
                break;
            } else {
                int symbolFromStackPriority;
                if (Objects.equals(symbolFromStack, "+") || Objects.equals(symbolFromStack, "-")) {
                    symbolFromStackPriority = 1;
                } else {
                    symbolFromStackPriority = 2;
                }
                if (priority < symbolFromStackPriority) {
                    resultPostfixExpression.add(String.valueOf(symbolFromStack));
                } else {
                    stack.push(symbolFromStack);
                    break;
                }
            }
        }
        stack.push(symbol);
    }
}
