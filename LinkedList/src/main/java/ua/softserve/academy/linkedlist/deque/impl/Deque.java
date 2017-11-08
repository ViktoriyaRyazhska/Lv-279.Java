package ua.softserve.academy.linkedlist.deque.impl;

import ua.softserve.academy.linkedlist.linked.list.impl.LinkedList;

public class Deque<T> implements ua.softserve.academy.linkedlist.deque.Deque<T>{


    private LinkedList<T> deque;

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public int size() {
        return deque.size();
    }

    public boolean contains(T value) {
        return deque.contains(value);
    }

    @Override
    public T PeakLast() {
        return deque.get(deque.size()-1);
    }

    @Override
    public T PeakFirst() {
        return deque.get(0);
    }

    @Override
    public T DequeueLast() {
        T value = deque.get(deque.size()-1);
        deque.remove(value);
        return value;
    }

    @Override
    public T DequeueFirst() {
        T value = deque.get(0);
        deque.remove(value);
        return value;
    }

    @Override
    public void EnqueueLast(T value) {
            deque.add(value);
    }

    @Override
    public void EnqueueFirst(T value) {

    }
}
