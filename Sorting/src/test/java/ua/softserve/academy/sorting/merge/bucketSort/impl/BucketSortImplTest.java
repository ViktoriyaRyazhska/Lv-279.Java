package ua.softserve.academy.sorting.merge.bucketSort.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.softserve.academy.sorting.merge.bucketSort.BucketSort;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BucketSortImplTest {
    BucketSort bucketSort;
    int[] array;

    @Before
    public void setUp() throws Exception {
        bucketSort = new BucketSortImpl();
         array = new int[]{4, 5, 9, 7, 3, 1, 6, 8, 2, 13, 14, 10, 11};
    }

    @After
    public void tearDown() throws Exception {
        bucketSort = null;
        array = null;
    }

    @Test
    public void msBits() throws Exception {
    }

    @Test
    public void bucketSort_minMax() throws Exception {
        bucketSort.bucketSort(array);

        assertEquals(1, array[0]);
        assertEquals(14, array[array.length-1]);
    }


    @Test
    public void bucketSort() throws Exception {
        int[] temp = array;

        bucketSort.bucketSort(array);

        Arrays.sort(temp);

        assertArrayEquals(temp, array);
    }

}