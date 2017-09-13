package com.aojiaoo.sort;

import com.aojiaoo.common.Common;

public class SelectionSort {

    private SelectionSort() {
    }

    public static void selectionSort(int[] arr) {

        int n = arr.length;
        int minIndex = 0;

        if (n < 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Common.swap(arr, i, minIndex);
        }
    }
}
