package ua.softserve.academy.linkedlist.circular.linked.list.teambn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.linkedlist.circular.linked.list.teambn.interfaces.ICircularLinkedList;

import static org.junit.Assert.assertEquals;

public class CircularLinkedListTest {
    ICircularLinkedList<String> testList;

    @Before
    public void setUp() throws Exception {
        testList = new CircularLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        testList = null;
    }

    @Test
    public void add() throws Exception {
        testList.add("Nazar");
        testList.add("Bohdan");
        assertEquals(true, testList.contains("Nazar"));
        assertEquals(false, testList.contains("Naz"));
        testList.clear();
    }

    @Test
    public void remove() throws Exception {
        testList.add("Nazar");
        testList.add("Bohdan");
        testList.remove("Nazar");
        assertEquals(false, testList.contains("Nazar"));
        assertEquals(true, testList.contains("Bohdan"));
        testList.add("Oleh");
        testList.remove("Oleh");
        assertEquals(false, testList.contains("Oleh"));
        testList.clear();
    }

    @Test
    public void next() throws Exception {
        testList.add("Nazar");
        testList.add("Bohdan");
        String expected = testList.next();
        assertEquals(expected, "Nazar");
        testList.clear();
    }

    @Test
    public void contains() throws Exception {
        testList.add("Nazar");
        testList.remove("Nazar");
        assertEquals(false, testList.contains("Nazar"));
        testList.add("Bohdan");
        assertEquals(true, testList.contains("Bohdan"));
        testList.add("Oleh");
        testList.remove("Oleh");
        assertEquals(false, testList.contains("Oleh"));
        testList.clear();
    }

    @Test
    public void size() throws Exception {
        testList.add("Nazar");
        assertEquals(1, testList.size());
        testList.remove("Nazar");
        assertEquals(0, testList.size());
        testList.clear();
    }

    @Test
    public void clear() throws Exception {
        testList.add("Nazar");
        testList.clear();
        assertEquals(0, testList.size());
    }
}