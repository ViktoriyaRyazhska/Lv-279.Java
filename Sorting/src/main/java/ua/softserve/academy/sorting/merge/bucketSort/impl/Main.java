package ua.softserve.academy.sorting.merge.bucketSort.impl;

import ua.softserve.academy.sorting.merge.bucketSort.BucketSort;

public class Main {

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSortImpl();

        int a[] = {4,5,9,7,3,1,6,8,2,13,14};

        System.out.println(Math.floor(12.0/3));
           /*
        for (int i = 0; i < a.length; i++) {
            System.out.println(bucketSort.msBits(a,i));
        }
             */

        //bucketSort.bucketSort(a);
       // System.out.println((int)Math.ceil((a.length)/3.0));
        for (int i = 0; i < a.length; i++) {
                            System.out.println(bucketSort.bucketSort(a)[i]);
        }


    }
}
