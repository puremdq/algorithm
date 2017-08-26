package sort;

import common.Common;


public class MergeSort {
    private MergeSort() {
    }


    /*进行数组归并操作*/
    private static void doMerge(int[] arr, int start, int m, int end) {

        int i = 0, j = 0, k = start, leftLen = m - start + 1, rightLen = end - m;

        int[] leftArr = Common.copyArray(arr, start, m);
        int[] rightArr = Common.copyArray(arr, m + 1, end);


        while (k <= end) {

            if (j == rightLen || (i < leftLen && leftArr[i] <= rightArr[j])) {
                arr[k++] = leftArr[i++];
            } else if (i == leftLen || (j < rightLen && rightArr[j] <= leftArr[i])) {
                arr[k++] = rightArr[j++];
            }

        }
    }

    //进行递归
    private static void doMergeSort(int[] arr, int start, int end) {


        if (end - start <= 15) {
            InsertSort.betterInsertSort(arr, start, 1, end);
            return;
        }

        int m = (start + end) / 2;
        doMergeSort(arr, start, m);
        doMergeSort(arr, m + 1, end);
        if (arr[m] > arr[m + 1]) {
            doMerge(arr, start, m, end);
        }
    }


    public static void mergeSort(int[] arr) {
        doMergeSort(arr, 0, arr.length - 1);
    }


}
