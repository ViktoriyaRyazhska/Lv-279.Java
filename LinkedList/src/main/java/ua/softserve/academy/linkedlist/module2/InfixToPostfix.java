package ua.softserve.academy.linkedlist.module2;
import java.util.List;

/**
 * Interface for transformation infix mathematical expression to postfix.
 */
public interface InfixToPostfix {
    /**
     * Method for transformation mathematical expression in Infix form to mathematical
     * expression in Postfix form.
     *
     * @param expression uses for receiving mathematical expression.
     * @return LinkedList that contains all operands and operators in the order of their execution
     */
    List<String> transfer(String expression);

}
