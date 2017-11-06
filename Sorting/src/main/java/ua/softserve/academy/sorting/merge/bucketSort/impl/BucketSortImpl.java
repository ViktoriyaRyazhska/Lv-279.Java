package ua.softserve.academy.sorting.merge.bucketSort.impl;

import org.omg.CORBA.BAD_CONTEXT;
import ua.softserve.academy.sorting.merge.bucketSort.BucketSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSortImpl implements BucketSort{

    public static void main(String[] args) {

    }
    static int BUCKET_COUNT;

    @Override
    public  int msBits(int[] array, int index) {

        int minValue = array[0];
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return  (int) Math.floor(BUCKET_COUNT*(array[index]-minValue)/(maxValue-minValue));
    }

    @Override
    public int[] bucketSort(int[] array) {

        BUCKET_COUNT = Math.round(array.length/3);


        int bucketCount = BUCKET_COUNT;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // Distribute input array values into buckets
        for (int i = 0; i < array.length; i++) {
            buckets.get(msBits(array,i)).add(array[i]);
        }

        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            Arrays.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
        return array;
    }
}
