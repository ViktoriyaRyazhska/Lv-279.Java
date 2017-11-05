/*
* Main
*
* Version 1.0-SNAPSHOT
*
* 05.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.sorting;

import ua.softserve.academy.sorting.merge.sort.DemoClassForMergeSort;

public class Main {

    private static final int DEMO_ARRAY_SIZE = 5;

    public static void main(String[] args) {

        DemoClassForMergeSort demo = new DemoClassForMergeSort(DEMO_ARRAY_SIZE);

        for (int i = 0; i < DEMO_ARRAY_SIZE; i++) {
            demo.setPersonByIndex(i, new DemoClassForMergeSort.Person("Name" + (i + 1), 30 - i));
        }

        System.out.println("-----------------------\nArray\n-----------------------");

        for (DemoClassForMergeSort.Person person : demo.getArray()) {
            System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
        }

        System.out.println("-----------------------\nSorted as Array\n-----------------------");

        for (DemoClassForMergeSort.Person person : demo.sort(DemoClassForMergeSort.Person.class)) {
            System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
        }

        System.out.println("-----------------------\nSorted as List\n-----------------------");

        for (DemoClassForMergeSort.Person person : demo.sortAsList()) {
            System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
        }

    }
}