/*
* MergeSort
*
* Version 1.0-SNAPSHOT using Comparable
*
* 05.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.academy.sorting.merge.sort.interfaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This interface is used for sorting data of array or data of list.
 * You have two ways to use it.
 * 1. You can implement this interface in your class which must be Comparable
 *    and sort your array with default method sort.
 * 2. You can also use defaults methods of this interface such as mergeSort
 *    and mergeSortAsList.
 * @param <T> class which will be sorted.
 */
public interface MergeSort<T extends Comparable> {

    /**
     * It is necessary method for sort() method.
     * sort() method uses getArray() to get array which will be sorted.
     * @return actual array for sorting.
     */
    T[] getArray();

    /**
     * This method sorts the array which was given from getArray() method.
     * @param clazz Class type of class which will be sorted (e.g. "Person.class").
     *              It is necessary because java doesn't support array of generics.
     *              Method sort() uses it for creation array of correct type.
     * @return sorted array.
     */
    default T[] sort(Class<?> clazz){
        List<T> array = Arrays.asList(getArray());
        return mergeSort(getArray(), clazz);
    }

    /**
     * This method sorts the array which was given from getArray() method.
     * This method uses List for sorting data.
     * It means before sorting array is converted to List.
     * @return sorted array as List.
     */
    default List<T> sortAsList(){
        List<T> array = Arrays.asList(getArray());
        return mergeSortList(array);
    }

    /**
     * This is recursive method for sorting data of array.
     * @param arr array which will be sorted.
     * @param clazz Class type of class which will be sorted (e.g. "Person.class").
     *              It is necessary because java doesn't support array of generics.
     *              Method sort() uses it for creation array of correct type.
     * @return sorted array.
     */
    default T[] mergeSort(T[] arr, Class<?> clazz){
        if (arr == null) {
            return null;
        }
        if (arr.length < 2) {
            return arr;
        }
        if (arr.length == 2) {
            if (0 < (arr[0].compareTo(arr[1]))) {
                T tmp = arr[0];
                arr[0] = arr[1];
                arr[1] = tmp;
            }
            return arr;
        }
        T[] part1 = mergeSort(Arrays.copyOfRange(arr, 0, arr.length / 2), clazz);
        T[] part2 = mergeSort(Arrays.copyOfRange(arr, arr.length / 2, arr.length), clazz);

        T[] resArr = (T[])Array.newInstance(clazz, part1.length + part2.length);

        int i = 0;
        int j = 0;
        int k = 0;
        while((j < part1.length) && (k < part2.length)){
            if (0 > (part1[j].compareTo(part2[k]))) {
                resArr[i++] = part1[j++];
            } else resArr[i++] = part2[k++];
        }
        for (int l = j; l < part1.length; l++){
            resArr[i++] = part1[l];
        }
        for (int l = k; l < part2.length; l++){
            resArr[i++] = part2[l];
        }

        return resArr;
    }

    /**
     * This is recursive method for sorting data of List.
     * @param listIn list which will be sorted.
     * @return sorted List.
     */
    default List<T> mergeSortList(List<T> listIn){
        if (listIn == null) {
            return null;
        }
        if (listIn.size() < 2) {
            return listIn;
        }
        if (listIn.size() == 2) {
            if (0 < (listIn.get(0).compareTo(listIn.get(1)))) {
                T tmp = listIn.get(0);
                listIn.set(0, listIn.get(1));
                listIn.set(1, tmp);
            }
            return listIn;
        }
        List<T> part1 = mergeSortList(listIn.subList(0, listIn.size() / 2));
        List<T> part2 = mergeSortList(listIn.subList(listIn.size() / 2, listIn.size()));
        List<T> resArr = new ArrayList<>();

        int j = 0;
        int k = 0;
        while((j < part1.size()) && (k < part2.size())){
            if (0 > (part1.get(j).compareTo(part2.get(k)))) {
                resArr.add(part1.get(j++));
            } else resArr.add(part2.get(k++));
        }
        for (int l = j; l < part1.size(); l++){
            resArr.add(part1.get(l));
        }
        for (int l = k; l < part2.size(); l++){
            resArr.add(part2.get(l));
        }

        return resArr;
    }

}