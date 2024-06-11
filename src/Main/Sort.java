/*
 * Sort.java
 * Leo Bogaert
 * June 12, 2024
 * This class contains the merge sort algorithm
 */
package Main;

import java.util.Arrays;

public class Sort {

    /**
     * Merge sort algorithm
     * @param arr int[] array to be sorted
     * @return int[] sorted array
     */
    public static int[] mergeSort (int[] arr){
        if (arr.length == 1) // base case
            return arr;

        // split arrays and merge
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left, right);
    }

    /**
     * Merge and sort two arrays
     * @param left int[] array left side
     * @param right int[] array right side
     * @return int[] merged and sorted array
     */
    private static int[] merge (int[] left, int[] right){
        int[] temp = new int[left.length + right.length]; // copy of the array

        int leftCounter = 0, rightCounter = 0, currentValue = 0;

        while (leftCounter < left.length && rightCounter < right.length){
            if (left[leftCounter] > right[rightCounter]){
                temp[currentValue] = left[leftCounter];
                leftCounter++;
            } else {
                temp[currentValue] = right[rightCounter];
                rightCounter++;
            }
            currentValue++;
        }

        // clean up left and right arrays
        while (leftCounter < left.length){
            temp[currentValue] = left[leftCounter];
            leftCounter++;
            currentValue++;
        }
        while (rightCounter < right.length){
            temp[currentValue] = right[rightCounter];
            rightCounter++;
            currentValue++;
        }
        return temp;
    }
}
