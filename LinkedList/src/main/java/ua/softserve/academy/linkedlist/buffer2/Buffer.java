package jar;

import jar.interfaces.IQueueOperation;

import java.util.Iterator;

/**
 * Created by yaoun on 05.11.2017.
 */
public class Buffer<T> implements IQueueOperation<T> {

    public boolean hasNext() {
        return false;
    }

    public T next() {
        return null;
    }

    public void remove() {

    }

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

    /*public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = first;

            public void remove() {
                Node<T> prev = current.getPrev();
                Node<T> next = current.getNext();
                if (first == last) {
                    first = null;
                    last = null;
                    return;
                }
                if (current == first){
                    first = next;
                }
                if (current == last) {
                    last = prev;
                }
                prev.setNext(next);
                next.setPrev(prev);
            }

            public boolean hasNext() {
                if (current.getNext() != null || current.getNext() != first || current != null) {
                    current = current.getNext();
                }
                return (last != null);
            }

            public T next() {
                T item = current.getItem();
                return item;
            }
        };
    }*/

    private Node<T> first;
    private Node<T> last;
    private Node<T> curr;
    private int size;


    public void enqueue(T val) {
        if (first==null) {
           first = new Node<T>(null,null,val);
           first.setNext(first);
           first.setPrev(first);
        }
        else if (last==null) {
            last = new Node<T>(first,first,val);
            first.setNext(last);
            first.setPrev(last);
        }
        else {
            Node<T> obj = new Node<T>(last,first,val);
            last.setNext(obj);
            last = obj;
            first.setPrev(last);
        }
        size++;
    }

    public void dequeue() {
        first = first.getNext();
        size--;
    }

    public T peak() {
        if (first!=null) {
            curr = first;
            dequeue();
            return curr.getItem();
        }
        else {
            return null; //solve bad value
        }
    }

    public boolean contains(T val) {
        if (first!=null) {
            curr = first;

            while (curr.getNext() != first) {
                if (curr.getItem().equals(val)) {
                    return true;
                }
                curr = curr.getNext();
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (first!=null){
            return false;
        }
        return true;
    }
}
