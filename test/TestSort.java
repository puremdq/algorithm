import com.aojiaoo.common.Common;

import java.lang.reflect.Method;

public class TestSort {


    private static void doTestSort(int[] arr, String className, String methodName) throws Exception {
        long startTime, endTime;
        Class<?> handle = Class.forName("com.aojiaoo.sort." + className);
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

    private static void testSort(int len,int min,int max) {

        try {

            int[] arr = Common.getArr(min, max, len);

            // arr = Common.getNearlyOrderly(len, 5);
            //Common.printArr(arr);

            doTestSort(Common.copyArray(arr), "SelectionSort", "selectionSort");
            doTestSort(Common.copyArray(arr), "InsertSort", "insertSort");
            doTestSort(Common.copyArray(arr), "InsertSort", "betterInsertSort");
            doTestSort(Common.copyArray(arr), "BubbleSort", "bubbleSort");
            doTestSort(Common.copyArray(arr), "BubbleSort", "betterBubbleSort");
            doTestSort(Common.copyArray(arr), "ShellSort", "shellSort");
            doTestSort(Common.copyArray(arr), "MergeSort", "mergeSort");
            doTestSort(Common.copyArray(arr), "QuickSort", "quickSort");
            doTestSort(Common.copyArray(arr), "QuickSort", "threeWayQuickSort");
            doTestSort(Common.copyArray(arr), "HeapSort", "heapSort");
            doTestSort(arr, "HeapSort", "indexHeapSort");

        } catch (Exception e) {

            System.out.println("Exception");
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {
        testSort(100000,1,2000);
    }
}
