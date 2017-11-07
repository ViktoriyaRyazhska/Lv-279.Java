/*
* JosephusProblem
*
* Version 1.0-SNAPSHOT
*
* 07.11.17
*
* All rights reserved by TeamBN (Team#2)
* */
package ua.softserve.academy.algorithms.linkedList.module_5.teambn;

import ua.softserve.academy.algorithms.linkedList.module_5.teambn.interfaces.ICircularLinkedList;

import java.util.Iterator;

/**
 * Class for solving Josephus problem using circular linked list.
 */
public class JosephusProblem {
    /**
     * Invoke this method for solving Josephus problem using circular linked list.
     *
     * @param numberOfPeople amount of people.
     * @return result.
     */
    public static int killThemAll(int numberOfPeople) {
        if (numberOfPeople < 1) {
            return 0;
        }
        ICircularLinkedList<Integer> listOfPeople = new CircularLinkedList<>();
        for (int i = 1; i <= numberOfPeople; i++) {
            listOfPeople.add(i);
        }

        Iterator<Integer> iterator = listOfPeople.iterator();
        while (listOfPeople.size() > 1) {
            iterator.next();
            listOfPeople.remove(iterator.next());
        }
        return listOfPeople.next();
    }
}

