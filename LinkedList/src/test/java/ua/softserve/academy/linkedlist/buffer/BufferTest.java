package ua.softserve.academy.linkedlist.buffer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BufferTest {
    Buffer buffer;

    @Before
    public void init() {
        buffer = new Buffer();
    }

    @Test
    public void enqueue() throws Exception {
        buffer.enqueue("str");
        assertEquals(buffer.peak(), "str");
    }

    @Test
    public void dequeue() throws Exception {
        buffer.enqueue("asdf");
        buffer.dequeue();
        assertEquals(buffer.isEmpty(), true);
    }

    @Test
    public void peak() throws Exception {
        buffer.enqueue("los");
        assertEquals(buffer.peak(), "los");
        assertEquals(buffer.size(), 0);

    }

    @Test
    public void contains() throws Exception {
        buffer.enqueue("asd");
        buffer.enqueue(13);
        buffer.enqueue(753);
        assertEquals(buffer.contains("asd"), true);
        assertEquals(buffer.contains(753), true);
        assertEquals(buffer.contains(1243), false);
    }

    @Test
    public void size() throws Exception {
        assertEquals(buffer.size(), 0);
        buffer.enqueue(123);
        assertEquals(buffer.size(), 1);
        buffer.dequeue();
        assertEquals(buffer.size(), 0);
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(buffer.isEmpty(), true);
        buffer.enqueue(123);
        assertEquals(buffer.isEmpty(), false);
    }

    @Test
    public void testToString() {
    buffer.enqueue(13);
    buffer.enqueue("rom");
    String str = buffer.toString();
    assertEquals(str,"Buffer{13, rom}");


    }

}