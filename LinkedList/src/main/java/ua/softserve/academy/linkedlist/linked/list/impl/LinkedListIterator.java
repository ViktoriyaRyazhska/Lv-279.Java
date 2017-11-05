package ua.softserve.academy.linkedlist.linked.list.impl;

import ua.softserve.academy.linkedlist.linked.list.List;
import ua.softserve.academy.linkedlist.linked.list.ListIterator;
import ua.softserve.academy.linkedlist.linked.list.Node;

import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements ListIterator<T> {

    private int size;

    private Node<T> currentNode;

    private Node<T> edgeNode;

    public LinkedListIterator() {
        this.size = 0;
        this.currentNode = this.currentNode = new Node<>(null, null, null);

    }

    public LinkedListIterator(Node<T> node, int size, Node<T> eNode) {
        this.size = size;
        this.currentNode = node;
        this.edgeNode = eNode;
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
    private void repositioningForAdding(Node<T> el, T elem) {

            Node<T> newElem = new Node<T>(el.getPrevious(), elem, el);
            el.getPrevious().setNext(newElem);
            el.setPrevious(newElem);
            size++;

    }

    public void set(T value) {

        currentNode.setValue(value);
    }

    @Override
    public void add(T elem) {

        while (!edgeNode.isLast()){
            edgeNode = edgeNode.getNext();
        }
        insert(elem);
    }
    /*
    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        }

        if (size == 0) {
            Node<T> newElem = new Node<T>(null, elem, null);
            currentNode = newElem;
            edgeNode = newElem;
            size++;
        } else {
            while (!edgeNode.isLast()){
                edgeNode = edgeNode.getNext();
            }
            Node<T> newElem = new Node<T>(edgeNode, elem, null);
            e.setNext(newElem);
            last = newElem;
            size++;
        }
    }
*/
    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T value) {
        return false;
    }
/*
    @Override
    public boolean contains(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null argument");
        }
        while (hasPrevious()){

        }
    }*/

    @Override
    public void clear() {

    }
}
