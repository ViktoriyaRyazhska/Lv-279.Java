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

    @Test
    public void constructor() throws Exception {
        stringLinkedList = new LinkedList<>("Tom", "Bob", "Jack");
        assertEquals(3, stringLinkedList.size());
    }

    @Test
    public void size_ifRemoveObj() throws Exception {
        stringLinkedList.remove("Tom");
        assertEquals(2, stringLinkedList.size());
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
        assertEquals("Tom", stringLinkedList.get(0));
        assertEquals("Jack", stringLinkedList.get(1));
    }

    @Test
    public void remove_TrueFalse() throws Exception {
        assertEquals(false, stringLinkedList.remove("Ted"));
        assertEquals(true, stringLinkedList.remove("Bob"));

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

    @Test(expected = IllegalArgumentException.class)
    public void addNull() throws Exception {
        stringLinkedList.add(null);
        fail("Null argument");
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
        stringLinkedList.add("Tom");
        assertEquals(true, stringLinkedList.forwardIterator().hasNext());
    }

    @Test
    public void backwardIteratorNext() throws Exception {
        assertEquals("Jack", stringLinkedList.backwardIterator().next());
    }

    @Test(expected = NoSuchElementException.class)
    public void backwardIteratorIfEmptyNext() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.backwardIterator().next();
    }

    @Test
    public void backwardIteratorHasNext() throws Exception {
        assertEquals(true, stringLinkedList.backwardIterator().hasNext());
    }

    @Test
    public void backwardIteratorIfEmptyHasNext() throws Exception {
        stringLinkedList = new LinkedList<>();
        assertEquals(false, stringLinkedList.backwardIterator().hasNext());
    }

    @Test
    public void forwardIteratorSet() throws Exception {
        //stringLinkedList.forwardIterator().
    }
}