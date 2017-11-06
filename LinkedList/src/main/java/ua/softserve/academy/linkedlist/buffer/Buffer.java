package ua.softserve.academy.linkedlist.buffer;/*
 * Buffer
 *
 * v.1.0
 *
 * 05.11.2017
 *
 * All rights reserved by Team#3
 */

public class Buffer implements BufferInterface {
    private Item first;
    private Item last;
    private int size;

    private class Item {
        private Item next;
        private Object value;
        public Item(Object value) {
            this.value = value;
        }
    }


    @Override
    public void enqueue(Object value) {
        Item temp = new Item(value);
        if (first == null) {
            first = temp;
            last = temp;
        } else {
            last.next = temp;
            last = temp;
        }
        size++;
    }

    @Override
    public void dequeue() {
        first = first.next;
        size--;
    }

    @Override
    public Object peak() {
        Item temp = first;
        first = first.next;
        size--;
        return temp.value;
    }

    @Override
    public boolean contains(Object value) {
        Item temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.value.equals(value)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String str = "";
        str += first.value;
        Item temp = first.next;
        for (int i = 1; i < size; i++) {
            str += ", " + temp.value;
            temp = temp.next;
        }
        return "Buffer{" + str + '}';
    }
}
