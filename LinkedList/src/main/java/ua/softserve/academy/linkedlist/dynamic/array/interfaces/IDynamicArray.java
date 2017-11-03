/*
* IDynamicArray
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.dynamic.array.interfaces;

public interface IDynamicArray {

    void add(String item);
    void insert(int index, String item);
    String get(int index);
    int remove(int index);
    boolean contains(String item);
    int indexOf(String item);
    int size();
    void clear();
    void growArray();

}
