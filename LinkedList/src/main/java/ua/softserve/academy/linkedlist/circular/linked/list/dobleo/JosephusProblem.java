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

/**
 * Class for solving Josephus problem using circular linked list.
 */
public class JosephusProblem {

    /**
     * Invoke this method for solving Josephus problem using circular linked list.
     * @param size amount of elements.
     * @return result.
     */
    public static int execute(int size) {
        if (size < 1) {
            return 0;
        }
        ICircularLinkedList<Integer> list = new CircularLinkedList<>();
        for (int i = 1; i <= size; i++){
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        iterator.hasNext();
        while (list.size() > 1){
            iterator.hasNext();
            iterator.remove();
        }
        return iterator.next();
    }
}
