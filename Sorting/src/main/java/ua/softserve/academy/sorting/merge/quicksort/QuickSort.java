package ua.softserve.academy.sorting.merge.quicksort;

public class QuickSort {
    public static int[] qsort(int[] arr) {
       int first=0;
       int last =arr.length-1;
       int sArr[]=new int[arr.length];
       for (int i=0;i<arr.length;i++){
           sArr[i]=arr[i];
       }
       sort(sArr, first,last);
    return sArr;
    }
    private static void sort ( int[] arr, int first, int last){
        int mid = (first + last + 1) / 2;
        int left = first;
        int right = last;
        for (int i = mid; i <= right; i++) {
            for (int j = left; j < mid; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        if (left + 1 < mid) sort(arr, left, mid);
        if (mid < right) sort(arr, mid, right);
    }
}