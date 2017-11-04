/*
* CircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.circular.linked.list;

import ua.softserve.academy.linkedlist.circular.linked.list.interfaces.ICircularLinkedList;

import java.util.Iterator;

/**
 * Circular linked list class.
 */
public class CircularLinkedList<T> implements ICircularLinkedList<T>, Iterable<T> {

    private class Node<T>{
        private Node<T> next;
        private Node<T> prev;
        private T item;

        public Node(Node<T> prev, Node<T> next, T item) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }

        public Node() {
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "{" + ((item == null)?null:item)  + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node<?> node = (Node<?>) o;

            if (next != null ? !next.equals(node.next) : node.next != null) return false;
            if (prev != null ? !prev.equals(node.prev) : node.prev != null) return false;
            return item != null ? item.equals(node.item) : node.item == null;
        }

        @Override
        public int hashCode() {
            int result = next != null ? next.hashCode() : 0;
            result = 31 * result + (prev != null ? prev.hashCode() : 0);
            result = 31 * result + (item != null ? item.hashCode() : 0);
            return result;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public CircularLinkedList() {
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public void add(T item) {
        if (first == null){
            first = new Node<>(null, null, item);
        } else if (last == null){
            last = new Node<>(first, first, item);
        } else {
            last = new Node<>(last, first, item);
        }
        size++;
    }

    @Override
    public T remove(T item) {
        return null;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
