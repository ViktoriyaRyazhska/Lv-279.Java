package ua.softserve.academy.sorting.merge.bucketSort.impl;

import ua.softserve.academy.sorting.merge.bucketSort.BucketSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSortImpl implements BucketSort {
    private static int BUCKET_COUNT;

    @Override
    public int msBits(int[] array, int index) {

        double minValue = array[0];
        double maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return (int) Math.floor(BUCKET_COUNT * ((array[index] - minValue + 0.1) / (maxValue + 0.2 - minValue)));
    }

    @Override
    public int[] bucketSort(int[] array) {

        BUCKET_COUNT = (int) Math.ceil(((double) array.length) / 3.0);


        int bucketCount = BUCKET_COUNT;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get(msBits(array, i)).add(array[i]);
        }
        System.out.println("Contents of buckets");
        buckets.forEach(System.out::print);
        System.out.println();
        System.out.println("*******************");
        // Sort buckets and place back into input array
        System.out.println("Sorted buckets");
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            Arrays.sort(bucketArray);
            System.out.print(Arrays.asList(bucketArray));
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
        System.out.println();
        System.out.println("*******************");
        System.out.println("Merged sorted array");
        System.out.println(Arrays.toString(array));
        return array;
    }
}
