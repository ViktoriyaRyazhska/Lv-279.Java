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
public class CircularLinkedList<T> implements ICircularLinkedList<T> {

    private class Node<T>{
        private Node<T> next;
        private Node<T> prev;
        private T item;

        public Node(Node<T> prev, Node<T> next, T item) {
            this.next = next;
            this.prev = prev;
            this.item = item;
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
            return "" + (item);
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

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = first;

            @Override
            public void remove() {
                Node<T> prev = current.getPrev();
                Node<T> next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);
            }

            @Override
            public boolean hasNext() {
                if (current != null) {
                    current = current.getNext();
                }
                return (last != null);
            }

            @Override
            public T next() {
                T item = current.getItem();
                return item;
            }
        };
    }

    /**
     *
     * @param item
     */
    @Override
    public void add(T item) {
        if (first == null){
            first = new Node<>(null, null, item);
            first.setNext(first);
            first.setPrev(first);
        } else if (last == null){
            last = new Node<>(first, first, item);
            first.setNext(last);
        } else {
            Node<T> node = new Node<>(last, first, item);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     * @param item specified item
     * @return removed item or null if the specified item wasn't found
     */
    @Override
    public T remove(T item) {
        Iterator<T> iterator = this.iterator();
        for(int i = 0; i < size; i++){
            T current = iterator.next();
            if (current.equals(item)){
                iterator.remove();
                size--;
                return current;
            }
            iterator.hasNext();
        }
        return null;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean contains(T item) {
        Iterator<T> iterator = this.iterator();
        for(int i = 0; i < size; i++){
            T current = iterator.next();
            iterator.hasNext();
            if (current.equals(item)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CircularLinkedList{items=[");
        Iterator<T> iterator = this.iterator();
        for(int i = 0; i < size; i++){
            T current = iterator.next();
            iterator.hasNext();
            sb.append(current + " ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
