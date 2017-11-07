package ua.softserve.academy.algorithms.sorting.merge_sort.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This interface is used for sorting data of array or data of list.
 * You have two ways to use it.
 * 1. You can implement this interface in your class
 *    and sort your array with default method sort.
 * 2. You can also use defaults methods of this interface such as mergeSort.
 * @param <T> class which will be sorted.
 */
public interface MergeSortComparator<T> {

    /**
     * It is necessary method for sort() method.
     * sort() method uses getArray() to get array which will be sorted.
     * @return actual array for sorting.
     */
    T[] getArray();

    /**
     * It is necessary method for sort() method.
     * sort() method uses getComparator() to know how to sort.
     * @return actual array for sorting.
     */
    Comparator<T> getComparator();

    /**
     * This method sorts the array which was given from getArray() method.
     * This method uses List for sorting data.
     * It means before sorting array is converted to List.
     * @return sorted array as List.
     */
    default List<T> sort(){
        List<T> array = Arrays.asList(getArray());
        return mergeSort(array, getComparator());
    }

    /**
     * This is recursive method for sorting data of List.
     * @param listIn list which will be sorted.
     * @return sorted List.
     */
    default List<T> mergeSort(List<T> listIn, Comparator<T> comparator){
        if (listIn == null) {
            return null;
        }
        if (listIn.size() < 2) {
            return listIn;
        }
        if (listIn.size() == 2) {
            if (0 < (comparator.compare(listIn.get(0), listIn.get(1)))) {
                T tmp = listIn.get(0);
                listIn.set(0, listIn.get(1));
                listIn.set(1, tmp);
            }
            return listIn;
        }
        List<T> part1 = mergeSort(listIn.subList(0, listIn.size() / 2), comparator);
        List<T> part2 = mergeSort(listIn.subList(listIn.size() / 2, listIn.size()), comparator);
        List<T> resArr = new ArrayList<>();

        int j = 0;
        int k = 0;
        while((j < part1.size()) && (k < part2.size())){
            if (0 > (comparator.compare(part1.get(j),part2.get(k)))) {
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