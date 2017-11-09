package ua.softserve.academy.algorithms.linkedList.module_6.impl;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_6.Deque;

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

}