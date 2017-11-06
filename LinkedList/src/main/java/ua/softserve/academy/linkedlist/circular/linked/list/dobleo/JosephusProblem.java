/*
* JosephusProblem
*
* Version 1.0-SNAPSHOT
*
* 06.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.linkedlist.circular.linked.list.dobleo;

import ua.softserve.academy.linkedlist.circular.linked.list.dobleo.interfaces.ICircularLinkedList;

import java.util.Iterator;

public class JosephusProblem {

    private static final int LIST_SIZE = 7;

    public static void main(String[] args) {

        ICircularLinkedList<Integer> list = new CircularLinkedList<>();

        for (int i = 1; i <= LIST_SIZE; i++){
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (list.size() > 1){
            iterator.hasNext();
            iterator.remove();
            iterator.hasNext();
        }

        System.out.println(list);

    }

}
