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

import java.util.Arrays;

//TODO IndexOf - Get - Contains - Remove - Size

/**
 *
 * To-Do list class.
 * Made by using dynamic array.
 * First index = 0.
 *
 * */
public class DynamicArray implements IDynamicArray{

    private static final int DEFAULT_CAPACITY = 10;

    private String[] items;
    private int size;
    private int capacity;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        items = new String[capacity];
        size = 0;
    }

    @Override
    public void add(String item) {
        if (size==items.length){
            growArray();
        }
        items[size]=item;
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

    }

    @Override
    public String get(int index) {
        if (checkIndex(index)){
            return null;
        }
        return items[index];
    }

    @Override
    public int remove(int index) {
        if (checkIndex(index)){
            return -1;
        }
        for (int i = index; i < (size - 1); i++){
            items[i] = items[i+1];
        }
        items[size-1] = null;
        size--;
        return index;
    }

    @Override
    public boolean contains(String item) {
        for (String current : items){
            if (current.equals(item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++){
            if (items[i].equals(item)) return i;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public void growArray() {
        String newItems[] = new String[items.length*2];
        System.arraycopy(items, 0, newItems, 0, size);
        items=newItems;
    }

    private boolean checkIndex(int index){
        return ( (index > (size - 1)) || (index < 0) );
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}



/*
    the function Add(item) for appending items in the end of To-Do list.
    the function Insert(index, item) for appending items of the any position in the To-Do list.
    the function Get(index) for getting items from the To-Do list.
    the function Remove(index) for removing items from the To-Do list.
    the function Contains(item) for checking if value exists in the To-Do list.
    the function IndexOf(item) for returning the first position in the To-Do list whose value equals the provided value.
    the function Size() for returning the number of items in the To-Do list.
    the function Clear() for removing all items from the To-Do list.
    the function growArray() for increase capacity of the To-Do list twice.*/