package ua.softserve.academy.algorithms.linkedList.module_6;


public interface Deque<E> {
    void enqueueFirst(E value);

    void enqueueLast(E value);

    int size();

    E dequeueFirst();

    E dequeueLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();
}
