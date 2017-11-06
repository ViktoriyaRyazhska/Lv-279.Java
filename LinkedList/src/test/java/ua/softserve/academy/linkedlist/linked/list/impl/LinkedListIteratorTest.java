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
    public void next() throws Exception {
        assertEquals("Tom", stringLinkedList.forwardIterator().next());
    }

    @Test(expected = NoSuchElementException.class)
    public void next_ifLinkedListEmpty() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.forwardIterator().next();
    }
    @Test(expected = NoSuchElementException.class)
    public void next_ifNoMoreElements() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        while (iterator.hasNext()){
            iterator.next();        }
         iterator.next();
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
    public void previous() throws Exception {
        assertEquals("Tom", stringLinkedList.forwardIterator().next());
    }

    @Test(expected = NoSuchElementException.class)
    public void previous_ifLinkedListEmpty() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.forwardIterator().next();
    }
    @Test(expected = NoSuchElementException.class)
    public void previous_ifNoMoreElements() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        while (iterator.hasNext()){
            iterator.next();        }
        iterator.next();
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
    public void set() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        iterator.next();
        iterator.set("Tommy");
        assertEquals("Tommy", iterator.getCurrent().getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void set_ifValueNull() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        iterator.set(null);
        fail("Null argument");
    }

    @Test
    public void insertAtFirstPosForwardIterator() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        iterator.next();
        iterator.insert("Megan");
        assertEquals("Megan", stringLinkedList.get(0));
    }

    @Test
    public void insertAtMiddlePosForwardIterator() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        iterator.next();
        iterator.next();
        iterator.insert("Megan");
        assertEquals("Megan", stringLinkedList.get(1));
    }

    @Test
    public void insertAtLastPosForwardIterator() throws Exception {
        LinkedListIterator iterator = stringLinkedList.forwardIterator();
        while (iterator.hasPrevious()){
            iterator.previous();        }

        iterator.insert("Megan");
        assertEquals("Megan", stringLinkedList.get(2));
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

    @Test (expected = NoSuchElementException.class)
    public void insertIntoIteratorIfEmptyNext() throws Exception {
        stringLinkedList = new LinkedList<>();
        stringLinkedList.forwardIterator().insert("a");
    }

    @Test
    public void backwardIteratorHasNext() throws Exception {
        assertEquals(true, stringLinkedList.backwardIterator().hasNext());
    }
    @Test
    public void backwardIteratorHasPrevious() throws Exception {
        assertEquals(true, stringLinkedList.backwardIterator().hasPrevious());
    }

    @Test
    public void backwardIteratorIfEmptyHasNext() throws Exception {
        stringLinkedList = new LinkedList<>();
        assertEquals(false, stringLinkedList.backwardIterator().hasPrevious());
    }

    @Test
    public void insertAtFirstPosBackwardIterator() throws Exception {
        LinkedListIterator iterator = stringLinkedList.backwardIterator();
        iterator.previous();
        iterator.insert("Megan");
        assertEquals("Megan", stringLinkedList.get(2));
    }

}