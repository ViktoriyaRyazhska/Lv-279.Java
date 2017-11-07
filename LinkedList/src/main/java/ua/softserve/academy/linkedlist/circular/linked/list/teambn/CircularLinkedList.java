package ua.softserve.academy.linkedlist.circular.linked.list.teambn;/*
* CircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 05.11.17
*
* All rights reserved by TeamBN (Team#2)
* */

import ua.softserve.academy.linkedlist.circular.linked.list.teambn.interfaces.ICircularLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Circular linked list class. Implements ICircularLinkedList.
 *
 * @param <E> data type;
 */

public class CircularLinkedList<E> implements ICircularLinkedList<E> {
    /**
     * An element of list.
     *
     * @param <E> data type.
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;

        /**
         * Constructor of element.
         *
         * @param element value.
         */
        Node(E element) {
            this.element = element;
            this.next = null;
        }

        /**
         * @return element.
         */
        public E getElement() {
            return element;
        }

        /**
         * Set the element.
         *
         * @param element
         */
        public void setElement(E element) {
            this.element = element;
        }

        /**
         * @return next Node.
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Set the next Node.
         *
         * @param next
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (getElement() != null ? !getElement().equals(node.getElement()) : node.getElement() != null)
                return false;
            return getNext() != null ? getNext().equals(node.getNext()) : node.getNext() == null;
        }

        @Override
        public int hashCode() {
            int result = getElement() != null ? getElement().hashCode() : 0;
            result = 31 * result + (getNext() != null ? getNext().hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return element + "";
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    /**
     * Constructor of Circular Linked List.
     */
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.currentSize = 0;
    }

    /**
     * Add new item at the end of the list.
     *
     * @param item
     */
    @Override
    public void add(E item) {
        Node<E> newNode = new Node<>(item);
        if (size() == 0) {
            head = newNode;
            tail = newNode;
            newNode.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
        currentSize++;
    }

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     *
     * @param item specified item.
     */
    @Override
    public void remove(E item) {
        if (head == null) {
            return;
        }
        if (head.getElement().equals(item)) {
            head = head.getNext();
            tail.setNext(head);
            currentSize--;
            return;
        }
        Node current = head;
        for (int i = 0; i < size(); i++) {
            if (current.getNext().getElement().equals(item)) {
                current.setNext(current.getNext().getNext());
                currentSize--;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Moves to next element.
     *
     * @return value of current element.
     */
    @Override
    public E next() {
        Node<E> current = head;
        if (current == null) {
            throw new NoSuchElementException();
        }
        E element = current.getElement();
        current = current.getNext();
        return element;
    }

    /**
     * Finds the specified item in the list.
     *
     * @param item specified item.
     * @return true - item was found.
     * false - item wasn't found.
     */
    @Override
    public boolean contains(E item) {
        Iterator<E> iterator = this.iterator();
        for (int i = 0; i < size(); i++) {
            if (iterator.next().equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return current size of the list.
     *
     * @return current size of the list.
     */
    @Override
    public int size() {
        return currentSize;
    }

    /**
     * Removes all items from the list.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    /**
     * Implementation of Iterator.
     *
     * @return new instance of Iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            /**
             * Checks whether the next item is
             * @return true - if next element is present.
             *         false - if next element doesn't exist.
             */
            @Override
            public boolean hasNext() {
                return current.getNext() != null;
            }

            /**
             * Moves iterator to next element.
             * @return value of current element.
             */
            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E element = current.getElement();
                current = current.getNext();
                return element;
            }

            /**
             * Implementation of remove method.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{items=[ ");
        Iterator<E> iterator = this.iterator();
        for (int i = 0; i < size(); i++) {
            sb.append(iterator.next() + ", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
