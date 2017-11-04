/*
* CircularLinkedListTest
*
* Version 1.0-SNAPSHOT
*
* 04.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.linkedlist.circular.linked.list;

import org.junit.Test;
import ua.softserve.academy.linkedlist.circular.linked.list.interfaces.ICircularLinkedList;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CircularLinkedListTest {

    @Test
    public void iterator() throws Exception {

    }

    @Test
    public void add() throws Exception {
        ICircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void remove() throws Exception {
        ICircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.remove("c"));
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void contains() throws Exception {
        ICircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        System.out.println(list.size());
        System.out.println(list.contains("c"));
    }

    @Test
    public void size() throws Exception {
    }

    @Test
    public void clear() throws Exception {
        ICircularLinkedList<String> list = new CircularLinkedList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        System.out.println(list.size());
        System.out.println(list);
        list.clear();
        System.out.println(list.size());
        System.out.println(list);
    }

}