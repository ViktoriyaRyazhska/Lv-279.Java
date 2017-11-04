/*
* DynamicArrayG
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.dynamic.array;

import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArrayG;

/**
 *
 * Dynamic Array class.
 * Made by using dynamic array.
 * First index = 0.
 * Default capacity = 10;
 *
 * */
public class DynamicArrayG<T> implements IDynamicArrayG<T>{

    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int size;

    /**
     * Default constructor - creates array with default capacity 10.
     */
    public DynamicArrayG() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * This constructor creates array with the specified capacity.
     * @param capacity - no comments:).
     */
    public DynamicArrayG(int capacity) {
        items = (T[])new Object[capacity];
        size = 0;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item element to be appended to this list
     */
    @Override
    public void add(T item) {
        if (size == items.length){
            growArray();
        }
        items[size] = item;
        size++;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @return the element index of the element wanted to be inserted
     */
    @Override
    public int insert(int index, T item){
        if (index > size || index < 0){
            return index;
        }
        if (size == items.length){
            growArray();
        }
        System.arraycopy(items,0,items,0, index);
        System.arraycopy(items, index, items,index+1,size-index);
        size++;
        items[index] = item;
        return index;
    }

    /**
     * Method get - returns item by the specified index
     * @param index specified index
     * @return item[index]
     */
    @Override
    public T get(int index) {
        if ((index > (size - 1)) || (index < 0)){
            return null;
        }
        return items[index];
    }

    /**
     * Method remove - deletes the item by the specified index
     * @param index - specified index
     * @return <b>-1</b> it means we cannot find an item by this index
     * <br><b>>=0</b> Item successfully deleted
     */
    @Override
    public int remove(int index) {
        if ((index > (size - 1)) || (index < 0)){
            return -1;
        }
        for (int i = index; i < (size - 1); i++){
            items[i] = items[i+1];
        }
        size--;
        items[size] = null;
        return index;
    }

    /**
     * Method contains - checks the presence of an item
     * @param item specified item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {
        for (int i = 0; i < size; i++){
            if (items[i].equals(item)) return true;
        }
        return false;
    }

    /**
     * Method indexOf - returns the index of the specified item
     * @param item specified item
     * @return <b>-1</b> it means we cannot find an item by this index
     * <br><b>>=0</b> index of the specified item
     */
    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++){
            if (items[i].equals(item)) return i;
        }
        return -1;
    }

    /**
     * Method size - returns the size of array
     * @return int - size of array
     */
    @Override
    public int size() {
        return size;

    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            items[i] = null;
        }
        size = 0;
    }

    /**
     * Copies an array from the specified source array, beginning at the
     * specified position, to the specified position of the destination array.
     */
    @Override
    public void growArray() {
        T newItems[] = (T[])new Object[items.length*2];
        System.arraycopy(items, 0, newItems, 0, size);
        items=newItems;
    }

    @Override
    public String toString() {
        if (size==0){
            return "DynamicArray{items=[]}";
        }
        StringBuilder stringBuilder = new StringBuilder("DynamicArray{items=[");
        for (int i = 0; i < size-1; i++){
            stringBuilder.append(items[i].toString() + ", ");
        }
        stringBuilder.append(items[size-1].toString() + "]}");
        return stringBuilder.toString();
    }
}