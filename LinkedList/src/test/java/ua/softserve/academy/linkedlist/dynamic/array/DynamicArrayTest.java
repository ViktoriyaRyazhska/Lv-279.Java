/*
* DynamicArrayTest
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.linkedlist.dynamic.array;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArray;

import static org.junit.Assert.*;

/**
 * Methods: addTest, insertTest, clearTest, growArraySimpleTest, growArrayTestingHugeArray
 * were written for valid data testing
 * Methods: addTestInv, insertTestInv, clearTestInv, growArrayTestInv
 * were written for invalid data testing
 */
public class DynamicArrayTest {

    IDynamicArray da;

    @Before
    public void init(){
        da = new DynamicArray();
    }

    @Test
    public void addTest() throws Exception {
        da.add("Write some method.");
        da.add("Update some method.");
        da.add("Remove unnecessary variables.");
        assertEquals("Write some method.", da.get(0));
        assertEquals("Remove unnecessary variables.", da.get(2));
        assertEquals("Update some method.", da.get(1));
    }

    @Test
    public void insertTest() throws Exception {
        da.add("Write some method.");
        da.add("Update some method.");
        da.add("Remove unnecessary variables.");
        assertEquals("Something new todo.", da.insert(1, "Something new todo."));
        assertEquals("Write some method.", da.get(0));
        assertEquals("Remove unnecessary variables.", da.get(3));
        assertEquals("Something new todo.", da.get(1));
        assertEquals("Update some method.", da.get(2));
    }

    @Test
    public void clearTest() throws Exception {
        da.add("Write some method.");
        da.add("Update some method.");
        da.add("Remove unnecessary variables.");
        assertEquals(3, da.size());
        da.clear();
        assertEquals(0, da.size());
        assertEquals(null, da.get(0));
    }

    @Test
    public void growArraySimpleTest() throws Exception {
        int sizeBefore = da.getCapacity();
        da.growArray();
        int sizeAfter = da.getCapacity();
        assertEquals(sizeBefore*2, sizeAfter);
    }

    @Test
    public void growArrayTestingHugeArray() throws Exception {
        da = new DynamicArray(100000);
        int sizeBefore = da.getCapacity();
        da.growArray();
        int sizeAfter = da.getCapacity();
        assertEquals(sizeBefore*2, sizeAfter);
    }

//    Invalid data PART

    @Test
    public void addTestInv() throws Exception {
        da.add(null);
        da.add("Update some method.");
        da.add("Remove unnecessary variables.");
        assertEquals(null, da.get(0));
        assertEquals("Remove unnecessary variables.", da.get(2));
        assertEquals("Update some method.", da.get(1));
    }

    @Test
    public void insertTestInv() throws Exception {
        da.add("Write some method.");
        da.add("Update some method.");
        da.add("Remove unnecessary variables.");
        assertEquals(null, da.insert(55, "Something new todo."));
        assertEquals("Something new todo.", da.insert(1, "Something new todo."));
        assertEquals("Write some method.", da.get(0));
        assertEquals("Remove unnecessary variables.", da.get(3));
        assertEquals("Something new todo.", da.get(1));
        assertEquals("Update some method.", da.get(2));
    }

    @Test
    public void clearTestInv() throws Exception {
        assertEquals(0, da.size());
        da.clear();
        assertEquals(0, da.size());
        assertEquals(null, da.get(0));
    }

    @Test
    public void growArrayTestInv() throws Exception {
        da = new DynamicArray(100000);
        int sizeBefore = da.getCapacity();
        int sizeAfter = da.growArray();
        while (sizeBefore != sizeAfter) {
            assertEquals(sizeBefore * 2, sizeAfter);
            sizeBefore = da.getCapacity();
            sizeAfter = da.growArray();
        }
    }

}