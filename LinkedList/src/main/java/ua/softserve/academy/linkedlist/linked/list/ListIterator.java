package ua.softserve.academy.linkedlist.linked.list;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator {


    void set(T value);
    void insert(T value);
}