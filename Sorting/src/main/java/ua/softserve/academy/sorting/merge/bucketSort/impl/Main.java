package ua.softserve.academy.sorting.merge.bucketSort.impl;

import ua.softserve.academy.sorting.merge.bucketSort.BucketSort;

public class Main {

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSortImpl();

        int a[] = {4,5,9,7,3,1,6,8,2};
        bucketSort.bucketSort(a);

        System.out.println(bucketSort.bucketSort(a));

    }
}
