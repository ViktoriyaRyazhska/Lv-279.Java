/*
* IDynamicArray
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.linkedList.module_1.interfaces;

public interface IDynamicArray {

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item element to be appended to this list
     */
    void add(String item);

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @return the element index of the element wanted to be inserted
     */
    String insert(int index, String item);

    /**
     * Method get - returns item by the specified index
     * @param index specified index
     * @return item[index]
     */
    String get(int index);

    /**
     * Method remove - deletes the item by the specified index
     * @param index specified index
     * @return <b>-1</b> it means we cannot find an item by this index
     * <br><b>>=0</b> Item successfully deleted
     */
    String remove(int index);

    /**
     * Method contains - checks the presence of an item
     * @param item specified item
     * @return true or false
     */
    boolean contains(String item);

    /**
     * Method indexOf - returns the index of the specified item
     * @param item specified item
     * @return <b>-1</b> it means we cannot find an item by this index
     * <br><b>>=0</b> index of the specified item
     */
    int indexOf(String item);

    /**
     * Method size - returns the size of array
     * @return int - size of array
     */
    int size();

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    void clear();

    /**
     * Copies an array from the specified source array, beginning at the
     * specified position, to the specified position of the destination array.
     * @return new capacity. If new capacity stay as old it means
     * we already have the maximum capacity.
     */
    int growArray();

    /**
     * Method getCapacity - returns current capacity
     * @return current capacity
     */
    int getCapacity();

}
