package Main;

import java.util.Arrays;

public class Sort {

    public static int[] mergeSort (int[] arr){
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left, right);
    }

    public static int[] merge (int[] left, int[] right){
        int[] temp = new int[left.length + right.length];
        int leftCounter = 0, rightCounter = 0, currentValue = 0;

        while (leftCounter < left.length && rightCounter < right.length){
            if (left[leftCounter] < right[rightCounter]){
                temp[currentValue] = left[leftCounter];
                leftCounter++;
            } else {
                temp[currentValue] = right[rightCounter];
                rightCounter++;
            }
            currentValue++;
        }

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
