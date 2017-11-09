package ua.softserve.academy.sorting.merge.quicksort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void testQsort() throws Exception {
        int [] arr={3,5,1,6};
        int [] sArr={1,3,5,6};
        int [] qsArr=QuickSort.qsort(arr);
        for(int i=0;i<4;i++) {
            assertEquals(qsArr[i], sArr[i]);
        }
    }

}