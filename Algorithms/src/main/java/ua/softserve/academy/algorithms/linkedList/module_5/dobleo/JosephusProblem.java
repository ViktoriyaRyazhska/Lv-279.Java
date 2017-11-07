/*
* JosephusProblem
*
* Version 1.0-SNAPSHOT
*
* 06.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.algorithms.linkedList.module_5.dobleo;

import ua.softserve.academy.algorithms.linkedList.module_5.dobleo.interfaces.ICircularLinkedList;
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
        while (list.size() > 1){
            iterator.next();
            iterator.next();
            iterator.remove();
        }
        return iterator.next();
    }
}
