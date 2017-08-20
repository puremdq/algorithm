package sort;

import common.Common;

public class MergeSort {
    private MergeSort() {
    }

    private static void doMerge(int[] arr, int start, int m, int end) {

        int i = 0, j = 0, k = start, leftLen = m - start + 1, rightLen = end - m;

        int[] leftArr = Common.copyArray(arr, start, m);
        int[] rightArr = Common.copyArray(arr, m + 1, end);


        while (k <= end) {

            if (j == rightLen || (i < leftLen && leftArr[i] <= rightArr[j])) {
                arr[k++] = leftArr[i++];
            } else if (i == leftLen || (j < rightLen && leftArr[i] > rightArr[j])) {
                arr[k++] = leftArr[j++];
            }

        }
    }

    private static void __mergeSort(int[] arr, int start, int end) {


        if (start < end) {

            int m = (int) (start + end) / 2;

            __mergeSort(arr, start, m);
            __mergeSort(arr, m + 1, end);
            doMerge(arr, start, m, end);

        }

    }

    public static void mergeSort(int[] arr) {
        __mergeSort(arr, 0, arr.length - 1);
    }
}
