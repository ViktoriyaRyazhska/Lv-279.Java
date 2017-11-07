/*
* DynamicArrayTest
*
* Version 1.0-SNAPSHOT
*
* 03.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.algorithms.linkedList.module_1;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.algorithms.linkedList.module_1.interfaces.IDynamicArray;

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
            System.out.println("in");
            assertEquals(sizeBefore * 2, sizeAfter);
            sizeBefore = da.getCapacity();
            sizeAfter = da.growArray();
            System.out.println(sizeAfter);
        }
    }

    @Test
    public void growArrayInv2() throws Exception {
        da = new DynamicArray(Integer.MAX_VALUE);
        int sizeBefore = da.getCapacity();
        int sizeAfter = da.growArray();
        while (sizeBefore != sizeAfter) {
            assertEquals(sizeBefore * 2, sizeAfter);
            sizeBefore = da.getCapacity();
            sizeAfter = da.growArray();
        }
    }

    @Test
    public void growArrayInv3() throws Exception {
        da = new DynamicArray(51200000 - 10);
        int sizeBefore = da.getCapacity();
        int sizeAfter = da.growArray();
        while (sizeBefore != sizeAfter) {
            if (sizeBefore * 2 > 51200000) {
                assertEquals(51200000, sizeAfter);
            } else {
                assertEquals(sizeBefore * 2, sizeAfter);
            }
            sizeBefore = da.getCapacity();
            sizeAfter = da.growArray();
        }
    }

    @Test
    public void removeTest() throws Exception {
        da.add("Ivan");
        da.add("Nadia");
        da.add("Foma");
        da.remove(1);
        assertEquals("Ivan", da.get(0));
        assertEquals("Foma", da.get(1));
    }

    @Test
    public void containsTest() throws Exception {
        String p1=new String("Ivan");
        String p2=new String("Nadia");
        da.add(p1);
        da.add(p2);
        assertEquals(true, da.contains(p1));
        assertEquals(true, da.contains(p2));
    }

    @Test
    public void indexOfTest() throws Exception {
        String p1=new String("Ivan");
        String p2=new String("Nadia");
        da.add(p1);
        da.add(p2);
        assertEquals(0, da.indexOf(p1));
        assertEquals(1, da.indexOf(p2));
    }

    @Test
    public void size() throws Exception {
        da.add("Ivan");
        da.add("Nadia");
        da.add("Foma");
        da.remove(1);
        assertEquals(2, da.size());
    }
}