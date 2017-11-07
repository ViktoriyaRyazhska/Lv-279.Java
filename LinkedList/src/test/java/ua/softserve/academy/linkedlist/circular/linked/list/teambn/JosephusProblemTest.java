/*
* JosephusProblemTest
*
* Version 1.0-SNAPSHOT
*
* 07.11.17
*
* All rights reserved by TeamBN (Team#2)
* */
package ua.softserve.academy.linkedlist.circular.linked.list.teambn;

import org.junit.Test;

import static org.junit.Assert.*;

public class JosephusProblemTest {
    @Test
    public void killThemAll() throws Exception {
        assertEquals(19, JosephusProblem.killThemAll(41));
        assertEquals(7, JosephusProblem.killThemAll(7));
        assertEquals(0, JosephusProblem.killThemAll(0));
        assertEquals(0, JosephusProblem.killThemAll(-100));
    }

}