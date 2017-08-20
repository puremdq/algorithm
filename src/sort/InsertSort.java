package sort;

import common.Common;

/*插入排序*/
public class InsertSort {

    private InsertSort() {
    }

    /*带有步长*/
    public static void insertSort(int[] arr, int... args) {

        int start = 0;
        int d = 1;

        if (args.length >= 2) {

            start = args[0];
            d = args[1];
        }

        int length = arr.length;
        int i, j;
        for (i = start + d; i < length; i = i + d) {

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

    /*带有步长*/
    public static void betterInsertSort(int[] arr, int... args) {

        int start = 0;
        int d = 1;

        if (args.length >= 2) {
            start = args[0];
            d = args[1];
        }

        int length = arr.length;
        int i, tempIndex;
        int temp, flag;

        //i之前都已经有序
        for (i = start + d; i < length; i = i + d) {

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


    public static void betterInsertSort(int[] arr) {
        betterInsertSort(arr, 0, 1);
    }

    public static void insertSort(int[] arr) {
        insertSort(arr, 0, 1);
    }
}
