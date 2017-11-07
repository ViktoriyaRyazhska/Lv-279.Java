/*
* DynamicArray
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.linkedList.module_1;

import ua.softserve.academy.algorithms.linkedList.module_1.interfaces.IDynamicArray;

/**
 *
 * To-Do array class.
 * Made by using dynamic array.
 * First index = 0.
 * Default capacity = 10;
 * Maximum capacity = 51200000;
 *
 * */
public class DynamicArray implements IDynamicArray {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_CAPACITY = 51200000;

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
        if (capacity<=MAX_CAPACITY) {
            items = new String[capacity];
        }
        else {
            items=new String[MAX_CAPACITY];
        }
        size = 0;
    }

    /**
     * Appends the String element to the end of this list.
     *
     * @param item element to be appended to this list
     */
    @Override
    public void add(String item) {
        if (size==MAX_CAPACITY){
            System.out.println("Already full!");
            return;
        }
        if (size == items.length){
            growArray();
        }
        items[size] = item;
        size++;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the String element.
     *
     * @param index index of the element to replace
     * @param item element to be stored at the specified position
     * @return the element index of the element wanted to be inserted
     */
    @Override
    public String insert(int index, String item) {
        if (index > size || index < 0){
            return null;
        }
        if (size==items.length){
            growArray();
        }
        System.arraycopy(items,0,items,0,index);
        System.arraycopy(items,index,items,index+1,size-index);
        items[index]=item;
        size++;
        return item;
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
    public String remove(int index) {
        if ((index > (size - 1)) || (index < 0)){
            return null;
        }
        String removed = items[index];
        for (int i = index; i < (size - 1); i++){
            items[i] = items[i+1];
        }
        items[size-1] = null;
        size--;
        return removed;
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
     * Copies an array from the String source array, beginning at the
     * specified position, to the specified position of the destination array.
     * @return new capacity. If new capacity stay as old it means
     * we already have the maximum capacity.
     */
    @Override
    public int growArray() {
        if ((items.length * 2) <= MAX_CAPACITY) {
            String newItems[] = new String[items.length*2];
            System.arraycopy(items, 0, newItems, 0, size);
            items=newItems;
        }
        else if (items.length < MAX_CAPACITY){
            String newItems[] = new String[MAX_CAPACITY];
            System.arraycopy(items, 0, newItems, 0, size);
            items=newItems;
        }
        return items.length;
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

    /**
     * Method getCapacity - returns current capacity
     * @return current capacity
     */
    @Override
    public int getCapacity(){
        return items.length;
    }
}