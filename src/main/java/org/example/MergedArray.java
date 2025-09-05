package org.example;

import java.util.Arrays;

public class MergedArray {

    public static void main(String[] args) {
        int[] arr = {1,6,7,9};
        int[] arr2 = {2,4,6,8};
        int n = arr.length, m = arr2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr[i] <= arr2[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        while (i < n) {
            merged[k++] = arr[i++];
        }

        while (j < n) {
            merged[k++] = arr2[j++];
        }
        System.out.println("Merged Array: " + Arrays.toString(merged));
    }
}
