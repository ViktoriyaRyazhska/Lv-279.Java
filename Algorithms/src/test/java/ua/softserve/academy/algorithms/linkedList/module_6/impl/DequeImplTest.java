package ua.softserve.academy.algorithms.linkedList.module_6.impl;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_4.impl.LinkedList;


import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeImplTest {
    private DequeImpl<String> deque;

    @Before
    public void setUp() {
        deque = new DequeImpl<String>();
        deque.enqueueLast("1");
        deque.enqueueLast("2");
        deque.enqueueLast("3");
    }


    @Test
    public void testIsEmpty() throws Exception {
        deque = new DequeImpl<>();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testSizeIsEmpty() throws Exception {
        deque = new DequeImpl<>();
        assertEquals(0, deque.size());
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(3, deque.size());
    }



    @Test
    public void testContainsInEmptyDeque() throws Exception {
        deque = new DequeImpl<>();
        assertFalse(deque.contains("4"));
    }

    @Test
    public void testContains() throws Exception {
        assertFalse(deque.contains("0"));
        assertTrue(deque.contains("1"));
    }


    @Test
    public void testCreateFromList() throws Exception {
        deque = new DequeImpl<>(new LinkedList<String>("a","b","c"));
        assertFalse(deque.isEmpty());
        assertTrue(deque.contains("a"));
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekFirstInEmptyDeque() throws Exception {
        deque = new DequeImpl<>();
        deque.peekFirst();
    }

    @Test
    public void testPeekFirst() throws Exception {
        assertEquals("1", deque.peekFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void testPeekLastInEmptyDeque() {

        deque = new DequeImpl<>();
        deque.peekLast();
    }


    @Test
    public void testPeekLast() throws Exception {
        assertEquals("3", deque.peekLast());
    }


    @Test
    public void testEnqueueFirst() throws Exception {
          deque.enqueueFirst("0");
        assertEquals("0", deque.peekFirst());
    }

    @Test
    public void testEnqueueLast() throws Exception {
        deque.enqueueLast("4");
        assertEquals("4", deque.peekLast());
    }

    @Test
    public void testDequeueFirst() throws Exception {
        assertTrue( deque.dequeueFirst());
        assertEquals("2", deque.peekFirst());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueFirstIfEmpty() throws Exception {
        deque = new DequeImpl<>();
        assertTrue( deque.dequeueFirst());

    }

    @Test
    public void testDequeueLast() throws Exception {
        assertTrue( deque.dequeueLast());
        assertEquals("2", deque.peekLast());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueLastIfEmpty() throws Exception {
        deque = new DequeImpl<>();
        assertTrue( deque.dequeueFirst());

    }

}