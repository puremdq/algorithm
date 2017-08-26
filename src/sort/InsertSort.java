package sort;

import common.Common;

/*插入排序*/
public class InsertSort {

    private InsertSort() {
    }

    /**
     * @param arr   int[]  要排序的数组
     * @param start int  开始位置
     * @param d     int 步长
     * @param end   int  结束位置
     */
    public static void doInsertSort(int[] arr, int start, int d, int end) {


        int i, j;
        for (i = start + d; i <= end; i = i + d) {

            for (j = i; j > start; j = j - d) {

                if (arr[j] >= arr[j - d]) {
                    break;
                }

                if (arr[j] < arr[j - d]) {
                    Common.swap(arr, j, j - d);
                }
            }
        }
    }


    /**
     * @param arr   int[]  要排序的数组
     * @param start int  开始位置
     * @param d     int 步长
     * @param end   int  结束位置
     */
    private static void doBetterInsertSort(int[] arr, int start, int d, int end) {


        int i, tempIndex;
        int temp, flag;

        //i之前都已经有序
        for (i = start + d; i <= end; i = i + d) {

            tempIndex = i;
            flag = 0;
            temp = arr[tempIndex];

            for (; tempIndex > start + d; tempIndex = tempIndex - d) {

                if (arr[tempIndex - d] > temp) {
                    arr[tempIndex] = arr[tempIndex - d];//向后移
                } else {
                    flag = 1;
                    arr[tempIndex] = temp;
                    break;
                }
            }
            if (flag == 0) {
                //未找到合适的位置
                arr[start] = temp;
            }
        }
    }




    public static void insertSort(int[] arr) {
        insertSort(arr, 0, 1, arr.length - 1);
    }
    public static void insertSort(int[] arr, int start, int d) {
        insertSort(arr, start, d, arr.length - 1);
    }
    public static void insertSort(int[] arr, int start, int d, int end) {
        doInsertSort(arr, start, d, end);
    }


    public static void betterInsertSort(int[] arr) {
        betterInsertSort(arr, 0, 1, arr.length - 1);
    }
    public static void betterInsertSort(int[] arr, int start, int d) {
        doBetterInsertSort(arr, start, d, arr.length - 1);
    }
    public static void betterInsertSort(int[] arr, int start, int d, int end) {
        doBetterInsertSort(arr, start, d, end);
    }




}
