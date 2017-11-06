package ua.softserve.academy.linkedlist.module2;

/**
 * Interface that contains method for Stack data structure.
 *
 * @param <T> set the type of the data that contains Stack.
 */
public interface Stack<T> {

    /**
     * Method that add element to the Stack.
     *
     * @param value Element that will be added to the Stack.
     */
    void push(T value);

    /**
     * Removes last added element from the Stack.
     *
     * @return last added element in the Stack.
     */
    T pop();

    /**
     * Show the last added element to the Stack.
     *
     * @return the last added element to the Stack.
     */
    T peak();

    /**
     * Method uses for checking if Stack contains element.
     *
     * @param value element that will be searching in the Stack.
     * @return false if the element wasn't found or true if the element was found.
     */
    boolean contains(T value);

    /**
     * Method for counting number of elements in the Stack.
     *
     * @return number of elements in the Stack.
     */
    int size();

    /**
     * Method uses for checking if the list is empty.
     *
     * @return true if the Stack is empty or false if the Stack is not empty.
     */
    boolean isEmpty();

}
