package ua.softserve.academy.algorithms.linkedList.module_6.impl;


import ua.softserve.academy.algorithms.linkedList.module_6.ListIterator;
import ua.softserve.academy.algorithms.linkedList.module_6.Node;

import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {


    private Node<T> currentNode;


    public LinkedListIterator(Node<T> node) {
        if (node == null) {
            this.currentNode = new Node<>(null, null, null);
        } else {
            if (node.getPrevious() == null) {
                this.currentNode = new Node<>(null, null, node);

            } else if (node.getNext() == null) {
                this.currentNode = new Node<>(node, null, null);

            }
        }
    }


    public Node<T> getCurrent() {
        return currentNode;
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

    public void set(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null argument");
        }
        currentNode.setValue(value);
    }

    @Override
    public void insert(T value) {
    }
}
