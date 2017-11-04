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
//    Add(item) for appending items in the end of Circular Linked List.
//    the function Remove(value) for removing items from the Circular Linked List.
//    the function Next() for getting items from the Circular Linked List and moving to next item in the list.
//    the function Contains(value) for checking if value exists in the Circular Linked List.
//    the function Size() for returning the number of items in the Circular Linked List.
//    the function Clear()
    void add(T item);
    T remove(T item);
    boolean contains(T item);
    int size();
    void clear();

}
