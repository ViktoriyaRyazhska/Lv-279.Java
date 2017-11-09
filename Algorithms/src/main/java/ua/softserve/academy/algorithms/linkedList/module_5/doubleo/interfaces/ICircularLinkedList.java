/*
* ICircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.linkedList.module_5.doubleo.interfaces;

public interface ICircularLinkedList<T> extends Iterable<T>{

    /**
     * Add new item at the end of the list.
     * @param item
     */
    void add(T item);

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     * @param item specified item
     * @return removed item or null if the specified item wasn't found
     */
    T remove(T item);

    /**
     * Finds the specified item in the list.
     * @param item
     * @return true - item was found.
     *         false - item wasn't found.
     */
    boolean contains(T item);

    /**
     * Return current size of the list.
     * @return current size of the list.
     */
    int size();

    /**
     * Removes all items from the list.
     */
    void clear();

}
