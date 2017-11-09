package ua.softserve.academy.algorithms.linkedList.module_6.impl;

import ua.softserve.academy.algorithms.linkedList.module_4.impl.LinkedList;
import ua.softserve.academy.algorithms.linkedList.module_6.Deque;


public class DequeImpl<T> implements Deque<T>{
    private LinkedList<T> deque;

    @Override
    public void enqueueFirst(T value) {
        deque.add(0, value);
    }

    @Override
    public void enqueueLast(T value) {
        deque.add(value);

    }

    @Override
    public boolean dequeueFirst() {
        deque.remove(deque.get(0));
        return true;
    }

    @Override
    public boolean dequeueLast() {
        deque.remove(deque.get(deque.size()-1));
        return true;
    }

    @Override
    public T peekFirst(){
        if(deque==null){
            throw new NullPointerException();
        }
        return deque.get(0);
    }

    @Override
    public T peekLast(){
        if(deque==null){
            throw new NullPointerException();
        }
        return deque.get(deque.size()-1);
    }

    @Override
    public boolean isEmpty(){
        return deque.isEmpty();
    }

    @Override
    public boolean contains(T value) {
        return deque.contains(value);
    }

    @Override
    public int size(){
        return deque.size();
    }

}
