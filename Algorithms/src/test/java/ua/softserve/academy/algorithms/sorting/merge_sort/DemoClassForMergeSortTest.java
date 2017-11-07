/*
* DemoClassForMergeSortTest
*
* Version 1.0-SNAPSHOT
*
* 06.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.algorithms.sorting.merge_sort;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.sorting.merge_sort.DemoClassForMergeSort.Person;
import java.util.*;
import static org.junit.Assert.assertEquals;

public class DemoClassForMergeSortTest {

    DemoClassForMergeSort demo;
    Random random;
    Comparator<Person> comparator;

    private static final int MIN_SIZE = 5;
    private static final int MAX_SIZE = 20;
    private static final int NAMES_NUM_TO = 4;
    private static final int MIN_AGE = 20;
    private static final int MAX_AGE = 40;

    @Before
    public void init() throws Exception{
        comparator = (Comparator.comparingInt(Person::getAge));
        random = new Random();
        int currentSize = random.nextInt(MAX_SIZE-MIN_SIZE)+MIN_SIZE;
        demo = new DemoClassForMergeSort(currentSize);
        for (int i = 0; i < currentSize; i++) {
            Person person = new Person(
                    "Name" + random.nextInt(NAMES_NUM_TO),
                    random.nextInt(MAX_AGE - MIN_AGE) + MIN_AGE);
            demo.setPersonByIndex(i, person);
        }
    }

    @Test
    public void sortAsArrayTest1() throws Exception {
        List<Person> people = Arrays.asList(demo.getArray());
        people.sort(comparator);
        Iterator<Person> iterator = people.iterator();
        for (Person person : demo.sort(Person.class)) {
            Person next = iterator.next();
            assertEquals(next.getAge(), person.getAge());
        }
    }

    @Test
    public void sortAsArrayTest2() throws Exception {
        List<Person> people = Arrays.asList(demo.getArray());
        people.sort(comparator);
        Iterator<Person> iterator = people.iterator();
        for (Person person : demo.sortAsList()) {
            Person next = iterator.next();
            assertEquals(next.getAge(), person.getAge());
        }
    }

    @Test
    public void sortAsArrayTest3() throws Exception {
        List<Person> people = Arrays.asList(demo.getArray());
        people.sort(comparator);
        Iterator<Person> iterator = people.iterator();
        for (Person person : demo.sort(Person.class)) {
            Person next = iterator.next();
            assertEquals(next.getAge(), person.getAge());
        }
    }

}