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

    public boolean contains(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Null argument");
        }
        Node<T> el = first;
        for (int i = 0; i < size; i++) {
            if (el.getValue().equals(value)) return true;
            el = el.getNext();
        }
        return false;
    }

    private void repositioningForRemoving(Node<String> el) {
        el.getPrevious().setNext(el.getNext());
        el.getNext().setPrevious(el.getPrevious());
        el.setNext(null);
        el.setPrevious(null);
        size--;
    }

    public boolean remove(String value) {
        if (value == null) {
            return false;
        }
        Node elem = first;
        for (int i = 0; i < size; i++) {
            if (elem.getValue().equals(value)) {
                repositioningForRemoving(elem);
                return true;
            }
            elem.getNext();
        }
        return false;
    }

    public void clear() {
        Node elem = first;
        for (int i = 0; i < size; i++) {
            repositioningForRemoving(elem);
            elem.getNext();
        }
    }

    public void add(T elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        } else {
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
    }


    @Override
    public boolean remove(T value) {
        return false;
    }
    public Iterator iterator() {
        return new LinkedListIterator(first,size);
    }
}