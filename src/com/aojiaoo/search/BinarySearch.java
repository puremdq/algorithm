package com.aojiaoo.search;

import com.aojiaoo.common.Common;
import com.aojiaoo.sort.QuickSort;

public class BinarySearch {

    private BinarySearch() {
    }


    /**
     * 二分查找
     *
     * @param arr   给定的数组
     * @param value 要找的值
     * @return 给定元素在数组中第一次出现的位置, 如果未找到返回-1
     */
    public static int binarySearch(int[] arr, final int value) {

        return doBinarySearch(arr, value, 0, arr.length - 1);
    }


    /**
     * 递归进行二分查找
     *
     * @param arr   给定的数组
     * @param value 要找的值
     * @param start 开始位置
     * @param end   结束位置
     * @return 给定元素在数组中第一次出现的位置, 如果未找到返回-1
     */
    private static int doBinarySearch(int[] arr, final int value, int start, int end) {


        if (start > end || value > arr[end] || value < arr[start]) {
            return -1;
        }

        //  int mid = (start + end) / 2;
        // 防止极端情况下的整形溢出，使用下面的逻辑求出mid
        int mid = start + (end - start) / 2;

        if (value < arr[mid]) {
            return doBinarySearch(arr, value, start, mid - 1);

        } else if (value > arr[mid]) {

            return doBinarySearch(arr, value, mid + 1, end);

        } else {
            return mid;
        }
    }


    public static void main(String[] args) {

        int[] arr = Common.getArr(1, 100000000, 100);
        QuickSort.quickSort(arr);
        int value = arr[Common.getNumberInRange(0, arr.length - 1)];
        int index = binarySearch(arr, value);

        if (index != -1) {

            System.out.println("search:" + value + "   find:" + arr[index]);
        } else {
            System.out.println("not found");
        }

    }
}
