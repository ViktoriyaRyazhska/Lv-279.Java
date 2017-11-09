package ua.softserve.academy.algorithms.sorting.counting_sort;

public class CountingSort {
    public static int[] doCountingSort(int[] inputArray) {
        for (int i : inputArray) {
            if(i < 0) {
                throw new IllegalArgumentException("Values in array must be more that 0");
            }
        }

        int[] outputArray = new int[inputArray.length];
        int minValue = inputArray[0];
        int maxValue = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[1] < minValue) {
                minValue = inputArray[i];
            } else {
                if (inputArray[i] > maxValue) {
                    maxValue = inputArray[i];
                }
            }
        }

        int[] arrOfIndexes = new int[maxValue - minValue + 1];

        for (int i = 0; i < inputArray.length; i++) {
            arrOfIndexes[inputArray[i] - minValue]++;
        }

        arrOfIndexes[0]--;

        for (int i = 1; i < arrOfIndexes.length; i++) {
            arrOfIndexes[i] = arrOfIndexes[i] + arrOfIndexes[i - 1];
        }

        for (int i = inputArray.length - 1; i >= 0; i--) {
            outputArray[arrOfIndexes[inputArray[i] - minValue]--] = inputArray[i];
        }

        return outputArray;
    }
}
