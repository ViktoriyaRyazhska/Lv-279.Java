/*
* CircularLinkedListTest
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.algorithms.linkedList.module_5.dobleo;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_5.dobleo.interfaces.ICircularLinkedList;
import static org.junit.Assert.*;

public class CircularLinkedListTest {
    ICircularLinkedList<String> list;

    @Before
    public void init(){
        list = new CircularLinkedList<>();
    }

    @Test
    public void add() throws Exception {
        list.add("a");
        assertEquals(true,list.contains("a"));
    }

    @Test
    public void hasNext() throws Exception {
        assertEquals(false,list.iterator().hasNext());
        list.add("a");
        assertEquals(true,list.iterator().hasNext());
    }

    @Test
    public void remove() throws Exception {
        list.add("a");
        list.add("b");
        list.add("b");
        list.remove("a");
        assertEquals(false, list.contains("a"));
    }

    @Test
    public void remove2() throws Exception {
        ICircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("c");
        list.add("b");
        assertEquals(true, list.contains("c"));
        assertEquals(true, list.contains("b"));
        list.remove("b");
        assertEquals(false, list.contains("b"));
        list.remove("c");
        assertEquals(false, list.contains("c"));
        assertEquals(0, list.size());
        list.add("b");
        list.add("c");
        list.add("d");
        assertEquals(true, list.contains("c"));
        assertEquals(true, list.contains("b"));
        assertEquals(true, list.contains("d"));
    }

    @Test
    public void contains() throws Exception {
        list.add("a");
        list.add("c");
        list.add("b");
        assertEquals(true, list.contains("a"));
        assertEquals(true, list.contains("b"));
        assertEquals(true, list.contains("c"));
        assertEquals(false, list.contains("cdas"));
    }

    @Test
    public void size() throws Exception {
        list.add("a");
        list.add("c");
        list.add("b");
        assertEquals(3, list.size());
    }

    @Test
    public void clear() throws Exception {
        list.add("a");
        list.add("c");
        list.add("b");
        list.clear();
        assertEquals(0, list.size());
        assertEquals(false, list.contains(null));
    }

}