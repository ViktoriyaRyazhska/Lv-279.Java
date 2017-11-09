package ua.softserve.academy.algorithms.linkedList.module_4.impl;


import ua.softserve.academy.algorithms.linkedList.module_4.Node;

import java.util.NoSuchElementException;


public class LinkedList<T> {

    private Node<T> first;
    private int size;
    private Node<T> last;

    public LinkedList() {
        first = last = null;
    }

    @SafeVarargs
    public LinkedList(T... elems) {
        for (T elem : elems) {
            add(elem);
        }
    }

    public int size() {
        return size;
    }

    private boolean checkIndex(int index) {

        return (index >= 0) && (index < size);
    }

    public T get(int index) {

        if (size() == 0) {
            throw new NoSuchElementException();
        }
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }

        if (index < size / 2) {

            Node<T> el = first;

            for (int i = 0; i < index; i++)
                el = el.getNext();

            return el.getValue();
        } else {
            Node<T> el = last;

            for (int i = size - 1; i > index; i--)
                el = el.getPrevious();

            return el.getValue();

        }
    }

    public boolean contains(T value) {
        return containsNode(value) != null;
    }

    private Node<T> containsNode(T value) {
        if (value != null) {
            for (Node<T> elem = first; elem != null; elem = elem.getNext()) {
                if (elem.getValue().equals(value)) {
                    return elem;
                }
            }
        }
        return null;
    }

    private void repositioningForRemoving(Node<T> el) {

        if (el.isSingle()) {
            deleteNode(el);
        } else {
            if (el.isFirst()) {
                first = el.getNext();
                el.deleteNextLink();
                deleteNode(el);
            } else if (el.isLast()) {
                last = el.getPrevious();
                el.deletePreviousLink();
                deleteNode(el);
            } else {
                el.deleteNextLink();
                el.deletePreviousLink();
                deleteNode(el);
            }
        }
    }

    private void deleteNode(Node node) {
        node.setNext(null);
        node.setPrevious(null);
        node.setValue(null);
        size--;

    }

    public boolean remove(T value) {

        if (value != null) {

            for (Node<T> elem = first; elem != null; elem = elem.getNext()) {
                if (elem.getValue().equals(value)) {

                    repositioningForRemoving(elem);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return (first == last) && (size == 0);
    }

    public void clear() {
        Node elem = first;
        while (!elem.isLast()) {
            Node<T> next = elem.getNext();
            elem.setNext(null);
            elem.setPrevious(null);
            elem.setValue(null);
            elem = next;
        }
        first = last = null;
        size = 0;
    }

    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        }

        if (size == 0) {
            Node<T> newElem = new Node<T>(null, elem, null);
            first = newElem;
            last = newElem;
            size++;
        } else {
            Node<T> newElem = new Node<T>(last, elem, null);
            last.setNext(newElem);
            last = newElem;
            size++;
        }
    }

    public void add(int index, T elem) {

        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        } else if ((size == 0) && (index == 0)) {
            add(elem);
        } else if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        } else if (index < size / 2) {

            Node<T> el = first;
            for (int i = 0; i < index; i++)
                el = el.getNext();
            repositioningForAdding(el, elem);
        } else {
            Node<T> el = last;
            for (int i = size - 1; i > index; i--)
                el = el.getPrevious();

            repositioningForAdding(el, elem);
        }
    }

    private void repositioningForAdding(Node<T> el, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        } else {

            if (el.getPrevious() == null) {
                Node<T> newElem = new Node<T>(el.getPrevious(), elem, el);
                el.setPrevious(newElem);
                first = newElem;
            } else {
                Node<T> newElem = new Node<T>(el.getPrevious(), elem, el);

                el.getPrevious().setNext(newElem);
                el.setPrevious(newElem);
                size++;
            }
        }
    }


    public LinkedListIterator<T> forwardIterator() {

        return new LinkedListIterator<T>(first) {
            @Override
            public boolean hasPrevious() {
                return hasNext();
            }

            @Override
            public T previous() {
                return next();
            }

            @Override
            public void insert(T value) {

                if (this.getCurrent().getValue() == null) {
                    throw new NoSuchElementException();
                }
                LinkedList.this.repositioningForAdding(this.getCurrent(), value);
            }
        };
    }


    public LinkedListIterator backwardIterator() {

        return new LinkedListIterator<T>(last) {

            @Override
            public boolean hasNext() {
                return hasPrevious();
            }

            @Override
            public T next() {
                return previous();
            }

            @Override
            public void insert(T value) {

                if (this.getCurrent().getValue() == null) {
                    throw new NoSuchElementException();
                }
                LinkedList.this.repositioningForAdding(this.getCurrent(), value);
            }

        };
    }


}