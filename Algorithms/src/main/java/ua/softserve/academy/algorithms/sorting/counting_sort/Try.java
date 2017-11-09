package ua.softserve.academy.algorithms.sorting.counting_sort;

import java.util.Arrays;

public class Try {
    public static void main(String[] args) {
        int[] unsortedForCountingSort = {11, 1, 100, 2, 7, 5, 2};

        System.out.println("Before: " + Arrays.toString(unsortedForCountingSort));
        int[] sorted = CountingSort.doCountingSort(unsortedForCountingSort);
        System.out.println("After: " + Arrays.toString(sorted));
    }
}
