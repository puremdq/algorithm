package sort;

import common.Common;

public class QuickSort {

    private static int partition(int[] arr, int start, int end) {

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot

        Common.swap(arr, start, Common.getNumberInRange(start, end));

        int v = arr[start];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = start + 1, j = end;

        while (true) {
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while (i <= end && arr[i] < v) {
                i++;
            }

            while (j >= start + 1 && arr[j] > v)
                j--;

            if (i > j) {
                break;
            } else {
                Common.swap(arr, i, j);
                i++;
                j--;
            }


        }

        Common.swap(arr, start, j);

        return j;
    }


    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void doThreeWayQuickSort(int[] arr, int start, int end) {

        // 对于小规模数组, 使用插入排序
        if (end - start <= 15) {
            InsertSort.insertSort(arr, start, 1, end);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        Common.swap(arr, start, Common.getNumberInRange(start, end));

        int v = arr[start];

        int lt = start;     // arr[start+1...lt] < v
        int gt = end + 1; // arr[gt...end] > v
        int i = start + 1;    // arr[lt+1...i) == v

        while (i < gt) {
            if (arr[i] < v) {
                Common.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > v) {
                Common.swap(arr, i, gt - 1);
                gt--;
            } else { // arr[i] == v
                i++;
            }
        }
        Common.swap(arr, start, lt);

        doThreeWayQuickSort(arr, start, lt - 1);
        doThreeWayQuickSort(arr, gt, end);
    }

    private static void doQuickSort(int[] arr, int start, int end) {


        if (end - start <= 15) {

            InsertSort.betterInsertSort(arr, start, 1, end);
            return;
        }


        int p = partition(arr, start, end);
        doQuickSort(arr, start, p - 1);
        doQuickSort(arr, p + 1, end);


    }


    public static void quickSort(int[] arr) {

        doQuickSort(arr, 0, arr.length - 1);
    }

    public static void threeWayQuickSort(int[] arr) {
        doThreeWayQuickSort(arr, 0, arr.length - 1);
    }
}
