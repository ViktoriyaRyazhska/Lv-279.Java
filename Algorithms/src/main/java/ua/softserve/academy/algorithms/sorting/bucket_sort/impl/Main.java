package ua.softserve.academy.algorithms.sorting.bucket_sort.impl;


import ua.softserve.academy.algorithms.sorting.bucket_sort.BucketSort;

public class Main {

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSortImpl();

        int a[] = {4, 5, 9, 7, 3, 1, 6, 8, 2, 13, 14, 10, 11};

        System.out.println(bucketSort.bucketSort(a).toString());
    }
}
