/* DynamicArrayGTest
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
*/

package ua.softserve.academy.linkedlist.dynamic.array;

import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.linkedlist.dynamic.array.interfaces.IDynamicArrayG;

import static org.junit.Assert.*;

/**
 * Methods: addTest, insertTest, clearTest, growArraySimpleTest, growArrayTestingHugeArray
 * were written for valid data testing
 * Methods: addTestInv, insertTestInv, clearTestInv, growArrayTestInv
 * were written for invalid data testing
 */
public class DynamicArrayGTest {

    IDynamicArrayG<Person> dag;

    private class Person{
        public int age;
        public String name;

        Person(int a, String n){
            age = a;
            name = n;
        }
    }

    @Before
    public void init(){
        dag = new DynamicArrayG<>();
    }

    @Test
    public void addTest() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        assertEquals("Ivan", dag.get(0).name);
        assertEquals("Foma", dag.get(2).name);
        assertEquals("Nadia", dag.get(1).name);
        assertEquals(20, dag.get(0).age);
        assertEquals(30, dag.get(2).age);
        assertEquals(25, dag.get(1).age);
    }

    @Test
    public void insertTest() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        assertEquals("Ostap", dag.insert(1, new Person(30, "Ostap")).name);
        assertEquals("Ivan", dag.get(0).name);
        assertEquals("Ostap", dag.get(1).name);
        assertEquals("Foma", dag.get(3).name);
        assertEquals("Nadia", dag.get(2).name);
        assertEquals(20, dag.get(0).age);
        assertEquals(30, dag.get(1).age);
        assertEquals(30, dag.get(3).age);
        assertEquals(25, dag.get(2).age);
    }

    @Test
    public void clearTest() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        assertEquals(3, dag.size());
        dag.clear();
        assertEquals(0, dag.size());
        assertEquals(null, dag.get(0));
    }

    @Test
    public void growArraySimpleTest() throws Exception {
        int sizeBefore = dag.getCapacity();
        dag.growArray();
        int sizeAfter = dag.getCapacity();
        assertEquals(sizeBefore*2, sizeAfter);
    }

    @Test
    public void growArrayTestingHugeArray() throws Exception {
        dag = new DynamicArrayG<>(100000);
        int sizeBefore = dag.getCapacity();
        dag.growArray();
        int sizeAfter = dag.getCapacity();
        assertEquals(sizeBefore*2, sizeAfter);
    }

//    Invalid data PART

    @Test
    public void addTestInv() throws Exception {
        dag.add(null);
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        assertEquals(null, dag.get(0));
        assertEquals("Foma", dag.get(2).name);
        assertEquals("Nadia", dag.get(1).name);
        assertEquals(30, dag.get(2).age);
        assertEquals(25, dag.get(1).age);
    }

    @Test
    public void insertTestInv() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        assertEquals(null, dag.insert(4, new Person(30, "Ostap")));
        assertEquals("Ostap", dag.insert(1, new Person(30, "Ostap")).name);
        assertEquals("Ivan", dag.get(0).name);
        assertEquals("Ostap", dag.get(1).name);
        assertEquals("Foma", dag.get(3).name);
        assertEquals("Nadia", dag.get(2).name);
        assertEquals(20, dag.get(0).age);
        assertEquals(30, dag.get(1).age);
        assertEquals(30, dag.get(3).age);
        assertEquals(25, dag.get(2).age);
    }

    @Test
    public void clearTestInv() throws Exception {
        assertEquals(0, dag.size());
        dag.clear();
        assertEquals(0, dag.size());
        assertEquals(null, dag.get(0));
    }

    @Test
    public void growArrayInv() throws Exception {
        dag = new DynamicArrayG<>(Integer.MAX_VALUE);
        int sizeBefore = dag.getCapacity();
        int sizeAfter = dag.growArray();
        while (sizeBefore != sizeAfter) {
            assertEquals(sizeBefore * 2, sizeAfter);
            sizeBefore = dag.getCapacity();
            sizeAfter = dag.growArray();
        }
    }

    @Test
    public void removeTest() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        dag.remove(1);
        assertEquals("Ivan", dag.get(0).name);
        assertEquals("Foma", dag.get(1).name);
    }

    @Test
    public void containsTest() throws Exception {
        Person p1=new Person(20,"Ivan");
        Person p2=new Person(25,"Nadia");
        dag.add(p1);
        dag.add(p2);
        assertEquals(true, dag.contains(p1));
        assertEquals(true, dag.contains(p2));
    }

    @Test
    public void indexOfTest() throws Exception {
        Person p1=new Person(20,"Ivan");
        Person p2=new Person(25,"Nadia");
        dag.add(p1);
        dag.add(p2);
        assertEquals(0, dag.indexOf(p1));
        assertEquals(1, dag.indexOf(p2));
    }

    @Test
    public void size() throws Exception {
        dag.add(new Person(20,"Ivan"));
        dag.add(new Person(25,"Nadia"));
        dag.add(new Person(30,"Foma"));
        dag.remove(1);
        assertEquals(2, dag.size());
    }

}
