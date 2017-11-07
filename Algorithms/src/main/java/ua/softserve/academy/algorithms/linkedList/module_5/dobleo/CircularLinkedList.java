/*
* CircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.linkedList.module_5.dobleo;

import ua.softserve.academy.algorithms.linkedList.module_5.dobleo.interfaces.ICircularLinkedList;
import java.util.Iterator;

/**
 * Circular linked list class. Implements ICircularLinkedList.
 * @param <T> data type.
 */
public class CircularLinkedList<T> implements ICircularLinkedList<T> {

    /**
     * An element of list.
     * @param <T> data type.
     */
    private class Node<T>{
        private Node<T> next;
        private Node<T> prev;
        private T item;

        /**
         * Constructor of element.
         * @param prev previous element.
         * @param next next element.
         * @param item value.
         */
        public Node(Node<T> prev, Node<T> next, T item) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }

        @Override
        public String toString() {
            return "" + item;
        }

        /*
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
        }*/
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public CircularLinkedList() {
    }

    /**
     * Implementation of Iterator.
     * @return new instance of Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = first;

            /**
             * Implementation of remove method.
             * Removes current element from the list.
             */
            @Override
            public void remove() {
                Node<T> removed = current.prev;
                Node<T> prev = removed.prev;
                Node<T> next = removed.next;
                if (first == last) {
                    first = null;
                    last = null;
                    size = 0;
                    return;
                }
                if (removed == first){
                    first = next;
                    last.next = first;
                }
                if (removed == last) {
                    last = prev;
                    first.prev = last;
                }
                prev.next = next;
                next.prev = prev;
                size--;
            }

            /**
             * Checks next element.
             * @return true - if next element is present.
             *         false - if next element doesn't exist.
             */
            @Override
            public boolean hasNext() {
                if (current == null) {
                    return false;
                }
                return current.next != null;
            }

            /**
             * Returns value of current element and moves to next element.
             * @return value of current element.
             */
            @Override
            public T next() {
                if (current == null){
                    return null;
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    /**
     * Add new item at the end of the list.
     * @param item
     */
    @Override
    public void add(T item) {
        if (first == null){
            first = new Node<>(null, null, item);
            first.next = first;
            first.prev = first;
        } else if (last == null){
            last = new Node<>(first, first, item);
            first.next = last;
            first.prev = last;
        } else {
            Node<T> node = new Node<>(last, first, item);
            last.next = node;
            last = node;
            first.prev = last;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     * @param item specified item.
     * @return removed item or null if the specified item wasn't found.
     */
    @Override
    public T remove(T item) {
        Iterator<T> iterator = this.iterator();
        for(int i = 0; i < size; i++){
            T current = iterator.next();
            if (current.equals(item)){
                iterator.remove();
                return current;
            }
        }
        return null;
    }

    /**
     * Finds the specified item in the list.
     * @param item
     * @return true - item was found.
     *         false - item wasn't found.
     */
    @Override
    public boolean contains(T item) {
        Iterator<T> iterator = this.iterator();
        for(int i = 0; i < size; i++){
            T current = iterator.next();
            if (current.equals(item)){
                return true;
            }
        }
        return false;
    }

    /**
     * Return current size of the list.
     * @return current size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all items from the list.
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * No comments:)
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CircularLinkedList{items=[");
        Iterator<T> iterator = this.iterator();
        for (int i = 0; i < size; i++) {
            T current = iterator.next();
            sb.append(current + " ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
