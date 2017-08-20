package sort;

import common.Common;

/*冒泡排序*/
public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        int n = arr.length;

        //总共n-1层
        for (int i = 0; i < n - 1; i++) {

            //每一层选取最大的放到最后
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    Common.swap(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * 改进的冒泡排序
     * 当 数组已经有序时直接退出
     */
    public static void betterBubbleSort(int[] arr) {

        int n = arr.length;
        int i = 0;

        boolean swapped = true;//记录是否已经有序

        while (swapped) {
            swapped = false;
            for (i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    //一直未进入此语句他就真的有序
                    Common.swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            n--;
        }
    }

}
