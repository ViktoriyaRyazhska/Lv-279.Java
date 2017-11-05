package ua.softserve.academy.linkedlist.linked.list;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node<String> node;
    Node<String> previous;
    String value;
    String value2;
    Node<String> next;

    @Before
    public void setUp() throws Exception {
        value = "Hello";
        value2 = "World!";

        previous = new Node<>(null, value, next);
        next = new Node<>(previous, value2, null);
        node = new Node<>(previous,value, next);
    }

    @After
    public void tearDown() throws Exception {
        node = null;
        previous = null;
        value = null;
        value2 = null;
        next = null;
    }

    @Test
    public void isSingle() throws Exception {
        Node<String> someNode = new Node<>(null,"1",null);
        assertEquals(true,someNode.isSingle());
    }

    @Test
    public void isFirst() throws Exception {
        assertEquals(null, previous.getPrevious());
        assertTrue(previous.getPrevious() == null);
    }

    @Test
    public void isLast() throws Exception {
        assertEquals(null, next.getNext());
        assertTrue(next.getNext() == null);
    }

    @Test
    public void getPrevious() throws Exception {
        assertEquals(previous, node.getPrevious());
    }

    @Test
    public void setPrevious() throws Exception {
        Node<String> newPreviousNode = new Node<>(null, "setNewNode", next);
        node.setPrevious(newPreviousNode);
        assertEquals(newPreviousNode, node.getPrevious());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals("Hello", node.getValue());
    }

    @Test
    public void setValue() throws Exception {
        value = "World!";
        node.setValue(value);
        assertEquals("World!", node.getValue());
    }

    @Test
    public void getNext() throws Exception {
        assertEquals(next, node.getNext());
    }

    @Test
    public void setNext() throws Exception {
        Node<String> newNextNode = new Node<>(null, "new next node", next);
        node.setNext(newNextNode);
        assertEquals(newNextNode, node.getNext());
    }

}