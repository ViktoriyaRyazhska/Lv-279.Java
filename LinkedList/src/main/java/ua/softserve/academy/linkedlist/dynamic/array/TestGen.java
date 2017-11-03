/*
* TestGen
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.dynamic.array;


import java.lang.reflect.Array;

public class TestGen<T> {

    private T[] items;
    private int size = 0;

    public TestGen(int s) {
        items = (T[])new Object[s];
    }

    public void add(T t){
        items[size] = t;
        size++;
    }

    public T get(int i){
        return items[i];
    }

    public static void main(String[] args) {
        TestGen<Integer> testGen = new TestGen<>(5);
        testGen.add(5);
        testGen.add(4);
        testGen.add(3);
        System.out.println(testGen.get(0));
        System.out.println(testGen.get(1));
        System.out.println(testGen.get(2));
    }


}
