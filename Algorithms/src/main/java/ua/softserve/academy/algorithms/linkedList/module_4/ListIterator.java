package ua.softserve.academy.algorithms.linkedList.module_4;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator {
    void set(T value);

    void insert(T value);
}