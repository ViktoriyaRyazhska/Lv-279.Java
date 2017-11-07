/*
* JosephusProblemTest
*
* Version 1.0-SNAPSHOT
*
* 06.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */
package ua.softserve.academy.algorithms.linkedList.module_5.dobleo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JosephusProblemTest {
    @Test
    public void execute() throws Exception {
        assertEquals(9, JosephusProblem.execute(12));
        assertEquals(17, JosephusProblem.execute(40));
        assertEquals(7, JosephusProblem.execute(7));
        assertEquals(1, JosephusProblem.execute(1));
        assertEquals(0, JosephusProblem.execute(0));
        assertEquals(0, JosephusProblem.execute(-10));
    }

}