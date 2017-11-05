package ua.softserve.academy.linkedlist.linked.list.impl;

import ua.softserve.academy.linkedlist.linked.list.List;
import ua.softserve.academy.linkedlist.linked.list.Node;

import java.util.Iterator;

import java.util.NoSuchElementException;


public class LinkedList<T> implements List<T> {


    private Node<T> first;
    private int size;
    private Node<T> last;

    public LinkedList() {
        first = last = new Node<T>(null, null, null);
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

        return index >= 0 && index < size;
    }

    public T get(int index) {

        if (!checkIndex(index)) throw new IndexOutOfBoundsException();

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
        if (value == null) {
            Node<T> el = first;
            for (int i = 0; i < size; i++) {
                if (el.getValue().equals(value)) return true;
                el = el.getNext();
            }
        }
        return false;
    }

    private void repositioningForRemoving(Node<T> el) {
        el.getPrevious().setNext(el.getNext());
        el.getNext().setPrevious(el.getPrevious());
        el.setNext(null);
        el.setPrevious(null);
        el.setValue(null);
        size--;
    }

    public boolean remove(T value) {
        if (value != null) {

            for (Node<T> elem = first; elem!=null ; elem = elem.getNext()) {
                if (elem.getValue().equals(value)) {
                    repositioningForRemoving(elem);
                    return true;
                }
            }
        }
        return false;
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
        first = last = new Node<T>(null, null, null);
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

    private void repositioningForAdding(Node<T> el, T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        } else {
            Node<T> newElem = new Node<T>(el.getPrevious(), elem, el);
            el.getPrevious().setNext(newElem);
            el.setPrevious(newElem);
            size++;
        }
    }


    public Iterator<T> forwardIterator() {

        return new Iterator<T>() {
            private Node<T> elem = first;

            public boolean hasNext() {
                return elem.getNext() != null;
            }

            public T next() {
                if (hasNext()) {
                    elem = elem.getNext();
                    return elem.getValue();
                } else throw new NoSuchElementException();
            }

            public void set(T value) {
                if (elem == null) {
                    throw new IllegalArgumentException("Null argument");
                }
                elem.setValue(value);
            }

            public void insert(T value) {
                repositioningForAdding(elem, value);
            }

        };
    }

    public Iterator backwardIterator() {

        return new Iterator<T>() {
            private Node<T> elem = last;

            public boolean hasNext() {
                return hasPrevious();
            }

            public T next() {
                return previous();

            }

            public boolean hasPrevious() {
                return elem.getPrevious() != null;
            }

            public T previous() {
                if (hasPrevious()) {
                    elem = elem.getPrevious();
                    return elem.getValue();
                } else throw new NoSuchElementException();
            }
        };
    }


    public Iterator iterator() {
        return new LinkedListIterator(first, size, last);
    }

    public Iterator iteratorBackWard() {
        return new LinkedListIterator(last, size, first);
    }
}