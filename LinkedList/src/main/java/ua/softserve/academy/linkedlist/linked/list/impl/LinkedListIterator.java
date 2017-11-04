package ua.softserve.academy.linkedlist.linked.list.impl;

import ua.softserve.academy.linkedlist.linked.list.List;
import ua.softserve.academy.linkedlist.linked.list.ListIterator;
import ua.softserve.academy.linkedlist.linked.list.Node;

import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {

    private int size;

    private Node<T> currentNode;

    public LinkedListIterator() {
        this.size = 0;
        this.currentNode = new Node<>(null, null, null);
    }

    public LinkedListIterator(Node<T> node, int size) {
        this.size = size;
        this.currentNode = node;
    }

    public boolean hasNext() {
        return currentNode.getNext() != null;
    }

    public T next() {
        if (hasNext()) {
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        } else throw new NoSuchElementException();

    }

    public boolean hasPrevious() {
        return currentNode.getPrevious() != null;
    }

    public T previous() {
        if (hasPrevious()) {
            currentNode = currentNode.getPrevious();
            return currentNode.getValue();
        } else throw new NoSuchElementException();

    }


    public void insert(T value) {
        Node<T> newElem = new Node<T>(currentNode.getPrevious(), value, currentNode);
        currentNode.getPrevious().setNext(newElem);
        currentNode.setPrevious(newElem);
        currentNode = newElem;
        size++;
    }

    public void set(T value) {
        currentNode.setValue(value);
    }

    @Override
    public void add(T elem) {

    }

    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void clear() {

    }
}
