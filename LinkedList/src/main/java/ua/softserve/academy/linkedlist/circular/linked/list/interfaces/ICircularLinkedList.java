/*
* ICircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.circular.linked.list.interfaces;

public interface ICircularLinkedList<T> extends Iterable<T>{

    void add(T item);

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     * @param item specified item
     * @return removed item or null if the specified item wasn't found
     */
    T remove(T item);

    boolean contains(T item);

    int size();

    void clear();

}
