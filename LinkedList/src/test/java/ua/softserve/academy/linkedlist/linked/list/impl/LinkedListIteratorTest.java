package ua.softserve.academy.linkedlist.linked.list.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListIteratorTest {
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
    public void currentAtStart() throws Exception {
        assertEquals(null, stringLinkedList.forwardIterator().getCurrent().getValue());
    }

    @Test
    public void currentAtIteration() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        iterator.next();
        assertEquals("Tom", iterator.getCurrent().getValue());
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
        stringLinkedList.add("a");
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


}