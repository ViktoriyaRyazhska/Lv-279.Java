package module2;

import java.util.List;

/**
 * Class uses for calculation postfix mathematical expression.
 */
public interface EvaluatePostfix {
    /**
     * Method uses for calculation postfix mathematical expression.
     *
     * @param postfixExpression postfix mathematical expression written in LinkedList.
     * @return result of calculation.
     */
    int evaluate(List<String> postfixExpression);
}
