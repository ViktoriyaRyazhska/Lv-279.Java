package module2.Impl;

import module2.Element;
import module2.Stack;

/**
 * Class that realize Stack data structure.
 *
 * @param <T> set the type of the data that contains Stack.
 */
public class StackImpl<T> implements Stack<T> {
    private Element<T> first = null;
    private int size = 0;

    /**
     * Method that add element to the Stack.
     *
     * @param value Element that will be added to the Stack.
     */
    @Override
    public void push(T value) {
        Element<T> element = new Element<>(value);
        if (isEmpty()) {
            first = element;
        } else {
            element.setNext(first);
            first = element;
        }
        size++;
    }

    /**
     * Removes last added element from the Stack.
     *
     * @return last added element in the Stack.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("There are no elements in the stack");
        } else {
            size--;
            Element<T> current = first;
            first = first.getNext();
            return current.getData();
        }
    }

    /**
     * Show the last added element to the Stack.
     *
     * @return the last added element to the Stack.
     */
    @Override
    public T peak() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("There are no elements in the stack");
        } else {
            return (T) first.getData();
        }
    }

    /**
     * Method uses for checking if Stack contains element.
     *
     * @param value element that will be searching in the Stack.
     * @return false if the element wasn't found or true if the element was found.
     */
    @Override
    public boolean contains(T value) {
        Element current = first;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            } else {
                current = current.getNext();
            }
        }
        return false;
    }

    /**
     * Method for counting number of elements in the Stack.
     *
     * @return number of elements in the Stack.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method uses for checking if the list is empty.
     *
     * @return true if the Stack is empty or false if the Stack is not empty.
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        Element current = first;

        StringBuilder build = new StringBuilder("");
        while (current != null) {
            build.append(current.toString());
            current = current.getNext();
        }
        return "Stack: {" + build.toString() +
                '}';
    }
}
