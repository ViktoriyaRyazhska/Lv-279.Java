package ua.softserve.academy.linkedlist.linked.list.impl;

import ua.softserve.academy.linkedlist.linked.list.List;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<String> implements List<String>, Iterable {

    private Node<String> first;
    private int size;
    private Node<String> last;

    public LinkedList() {
        first = last = new Node(null, null, null);
    }

    public LinkedList(String... elems) {
        for (String elem : elems) {
            add(elem);
        }
    }

    public int size() {
        return size;
    }

    public boolean contains(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Null argument");
        }
        Node<String> el = first;
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

    public void add(String elem) {
        if (elem == null) {
            throw new IllegalArgumentException("Null argument");
        } else {
            if (size == 0) {
                Node<String> newElem = new Node<String>(null, elem, null);
                first = newElem;
                last = newElem;
                size++;
            } else {
                Node<String> newElem = new Node<String>(last, elem, null);
                last.setNext(newElem);
                last = newElem;
                size++;
            }
        }
    }

    public Iterator iterator() {
        return new Iterator() {
            private Node<String> currentNode = first;

            public boolean hasNext() {
                return currentNode.getNext() != null;
            }

            public String next() {
                if (hasNext()) {
                    currentNode = currentNode.getNext();
                    return currentNode.getValue();
                } else throw new NoSuchElementException();

            }

            public boolean hasPrevious() {
                return currentNode.getPrevious() != null;
            }

            public String previous() {
                if (hasPrevious()) {
                    currentNode = currentNode.getPrevious();
                    return currentNode.getValue();
                } else throw new NoSuchElementException();

            }




            public void insert(String value) {
                Node<String> newElem = new Node<String>(currentNode.getPrevious(), value, currentNode);
                currentNode.getPrevious().setNext(newElem);
                currentNode.setPrevious(newElem);
                currentNode = newElem;
                size++;
            }

            public void set(String value) {
                currentNode.setValue(value);
            }
        };
    }

    class Node<String> {

        private Node<String> previous;
        private String value;
        private Node<String> next;

        public boolean isSingle() {
            return isFirst() && isLast();
        }

        public boolean isFirst() {
            return previous == null;
        }

        public boolean isLast() {
            return next == null;
        }

        public Node(Node<String> previous, String value, Node<String> next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

        public Node<String> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<String> previous) {
            this.previous = previous;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node<String> getNext() {
            return next;
        }

        public void setNext(Node<String> next) {
            this.next = next;
        }
    }
}
