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

public class DynamicArrayTest {

    IDynamicArray da;

    @Before
    public void init(){
        da = new DynamicArray();
    }

    /**
     * Methods: addTest, insertTest, growArraySimpleTest, growArrayTestingHugeArray
     * were written for valid data testing
     *
     */

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

}