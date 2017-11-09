package ua.softserve.academy.algorithms.linkedList.module_6;


import java.util.NoSuchElementException;

public interface Deque<E> {

    /**
     * Inserts the specified element at the front of this deque if it is
     * possible to do so immediately without violating capacity restrictions
     *
     * @param value the element to add
     *
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    void enqueueFirst(E value);

    /**
     * Inserts the specified element at the end of this deque if it is
     * possible to do so immediately without violating capacity restrictions
     *
     * @param value the element to add
     *
     * @throws IllegalArgumentException if some property of the specified
     *         element prevents it from being added to this deque
     */
    void enqueueLast(E value);

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    int size();

    /**
     * Retrieves and removes the first element of this deque.
     * @return the true or false depending on that object was deleted
     * @throws NoSuchElementException if this deque is empty
     */
    boolean dequeueFirst();

    /**
     * Retrieves and removes the last element of this deque.
     * @return the true or false depending on was object deleted or not.
     * @throws NoSuchElementException if this deque is empty.
     */
    boolean dequeueLast();

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque.
     * @throws  NullPointerException if deque is null;
     */
    E peekFirst();

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque.
     * @throws  NullPointerException if deque is null;
     */
    E peekLast();

    /**
     * @return true if this collection contains no elements
     */
    boolean isEmpty();

    /**
     * Returns {@code true} if this deque contains the specified element.
     * More formally, returns {@code true} if and only if this deque contains
     * at least one element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param value element whose presence in this deque is to be tested
     * @return {@code true} if this deque contains the specified element
     */
    boolean contains(E value);
}
