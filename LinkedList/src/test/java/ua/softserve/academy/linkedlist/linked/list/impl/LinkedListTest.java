package ua.softserve.academy.linkedlist.linked.list.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class LinkedListTest {
    LinkedList<String> stringLinkedList;

    @Before
    public void setUp() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Tom");
        stringLinkedList.add("Bob");
        stringLinkedList.add("Jack");
    }

    @After
    public void tearDown() throws Exception {
        stringLinkedList = null;
    }

    @Test
    public void get() throws Exception {
        assertEquals("Bob", stringLinkedList.get(1));
        assertEquals("Tom", stringLinkedList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegative() throws Exception {
        stringLinkedList.get(-1);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, stringLinkedList.size());
    }

    @Test(expected = NullPointerException.class)
    public void nullSize() throws Exception {
        stringLinkedList = null;
        stringLinkedList.size();
    }

    @Test
    public void contains() throws Exception {
        assertEquals(true, stringLinkedList.contains("Tom"));
        assertEquals(false, stringLinkedList.contains(null));

        stringLinkedList.add("Steve");
        assertEquals(true, stringLinkedList.contains("Steve"));
    }

    @Test
    public void remove() throws Exception {
        stringLinkedList.remove("Bob");
        assertEquals(2, stringLinkedList.size());
        assertEquals("Tom", stringLinkedList.get(0));
        assertEquals("Jack", stringLinkedList.get(1));
    }

    @Test
    public void clear() throws Exception {
        stringLinkedList.clear();
        assertEquals(0, stringLinkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAfterClear() throws Exception {
        stringLinkedList.clear();
        stringLinkedList.get(0);
    }

    @Test
    public void add() throws Exception {
        stringLinkedList.add("Steve");
        assertEquals("Steve", stringLinkedList.get(3));
    }

    @Test
    public void next() throws Exception {
        assertEquals("Tom", stringLinkedList.forwardIterator().next());
    }

    @Test(expected = NoSuchElementException.class)
    public void next_ifLinkedListEmpty() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.forwardIterator().next();
    }

    @Test
    public void hasNext_ifLinkedListEmpty() throws Exception {
        stringLinkedList = new LinkedList<>();
        assertEquals(false, stringLinkedList.forwardIterator().hasNext());
    }

    @Test
    public void hasNext_ifOnly1ObjPresent() throws Exception {
        stringLinkedList = new LinkedList<>();
        assertEquals(true, stringLinkedList.forwardIterator().hasNext());
    }

}