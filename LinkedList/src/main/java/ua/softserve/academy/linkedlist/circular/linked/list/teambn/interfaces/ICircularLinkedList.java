/*
* ICircularLinkedList
*
* Version 1.0-SNAPSHOT
*
* 05.11.17
*
* All rights reserved by TeamBN (Team#2)
* */
package ua.softserve.academy.linkedlist.circular.linked.list.teambn.interfaces;

public interface ICircularLinkedList<E> extends Iterable<E> {
    /**
     * Adds element value in the Circular Linked List.
     *
     * @param item specified item.
     */
    void add(E item);

    /**
     * Removes the first occurrence of the specified item from this list, if it is present.
     *
     * @param item specified item.
     */
    void remove(E item);

    /**
     * @return
     */
    E next();

    /**
     * Finds the specified item in the Circular Linked List.
     *
     * @param item specified item.
     * @return true - item was found.
     * false - item wasn't found.
     */
    boolean contains(E item);

    /**
     * Returns the number of items in the Circular Linked List.
     *
     * @return int.
     */
    int size();

    /**
     * Removes all items from the list.
     */
    void clear();
}

