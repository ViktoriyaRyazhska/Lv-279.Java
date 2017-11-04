/*
* DynamicArray
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.dynamic.array;

import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArray;

/**
 *
 * To-Do array class.
 * Made by using dynamic array.
 * First index = 0.
 * Default capacity = 10;
 *
 * */
public class DynamicArray implements IDynamicArray {

    private static final int DEFAULT_CAPACITY = 10;

    private String[] items;
    private int size;

    /**
     * Default constructor - creates array with default capacity 10.
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * This constructor creates array with the specified capacity.
     * @param capacity - no comments:).
     */
    public DynamicArray(int capacity) {
        items = new String[capacity];
        size = 0;
    }

    @Override
    public void add(String item) {
        if (size == items.length){
            growArray();
        }
        items[size] = item;
        size++;
    }

    @Override
    public void insert(int index, String item) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        if (size==items.length){
            growArray();
        }
        System.arraycopy(items,0,items,0,index);
        System.arraycopy(items,index,items,index+1,size-index);
        items[index]=item;
        size++;
    }

    /**
     * Method get - returns item by the specified index
     * @param index specified index
     * @return item[index]
     */
    @Override
    public String get(int index) {
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
        items[size-1] = null;
        size--;
        return index;
    }

    /**
     * Method contains - checks the presence of an item
     * @param item specified item
     * @return true or false
     */
    @Override
    public boolean contains(String item) {
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
    public int indexOf(String item) {
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

    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            items[i] = null;
        }
        size = 0;
    }

    @Override
    public void growArray() {
        String newItems[] = new String[items.length*2];
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
            stringBuilder.append(items[i] + ", ");
        }
        stringBuilder.append(items[size-1] + "]}");
        return stringBuilder.toString();
    }
}