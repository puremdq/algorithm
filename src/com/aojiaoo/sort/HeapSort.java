package com.aojiaoo.sort;

import com.aojiaoo.dataStructure.heap.Heap;
import com.aojiaoo.dataStructure.heap.IndexHeap;

public class HeapSort {

    public static void heapSort(int[] arr) {
        Heap.heapSort(arr);
    }

    public static void indexHeapSort(int[] arr) {
        IndexHeap.heapSort(arr);
    }
}
