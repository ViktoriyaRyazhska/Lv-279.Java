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
    int insert(int index, String item);
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
    int remove(int index);
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
    void clear();
    void growArray();

}
