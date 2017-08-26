import common.Common;

import java.lang.reflect.Method;

public class TestSort {


    private static void testSort(int[] arr, String className, String methodName) throws Exception {
        long startTime, endTime;
        Class<?> handle = Class.forName("sort." + className);
        Method method = handle.getMethod(methodName, int[].class);

        startTime = System.nanoTime();
        method.invoke(null, arr);
        endTime = System.nanoTime();

        if (Common.isArraySorted(arr)) {
            //Common.printArr(arr);
            System.out.println("\n" + methodName + "排序" + arr.length + "条数据 共耗时:" + (double) (endTime - startTime) / 1000000000 + " s");
        } else {
            //Common.printArr(arr);
            System.out.println(className + "排序失败");
        }

    }

    public static void main(String[] args) {
        try {
            int len = 100000;
            int min = -100000000;
            int max = 10000000;
            int[] arr;


            arr = Common.getArr(min, max, len);
            // arr = Common.getNearlyOrderly(len, 5);
            //Common.printArr(arr);

            testSort(Common.copyArray(arr), "SelectionSort", "selectionSort");
            testSort(Common.copyArray(arr), "InsertSort", "insertSort");
            testSort(Common.copyArray(arr), "InsertSort", "betterInsertSort");
            testSort(Common.copyArray(arr), "BubbleSort", "bubbleSort");
            testSort(Common.copyArray(arr), "BubbleSort", "betterBubbleSort");
            testSort(Common.copyArray(arr), "ShellSort", "shellSort");
            testSort(Common.copyArray(arr), "MergeSort", "mergeSort");
            testSort(Common.copyArray(arr), "QuickSort", "quickSort");
            testSort(Common.copyArray(arr), "QuickSort", "threeWayQuickSort");
            testSort(Common.copyArray(arr), "HeapSort", "heapSort");

        } catch (Exception e) {

            System.out.println("Exception");
            System.out.println(e.getMessage());
        }
    }
}
