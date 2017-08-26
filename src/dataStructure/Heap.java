package dataStructure;

import common.Common;

public class Heap {

    private int size = 0;//整个堆的容量
    private int[] heapArr = null;
    private int length = 0;//整个堆当前已经有的元素个数
    private String heapType = "max";//只能是 max或者min

    public static void heapSort(int[] arr) {

        Heap heap = new Heap(arr, arr.length, "min");

        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = heap.extract();
            }
        } catch (Exception e) {
            System.out.println("\nException:" + e.getMessage());
        }

    }

    public Heap(int size) {
        this.size = size;
        this.length = 0;
        this.heapArr = new int[size + 1];
    }

    /**
     * 可指定大顶堆还是小顶堆
     */
    public Heap(int size, String heapType) {
        this.size = size;
        this.heapArr = new int[size + 1];

        if (heapType.equals("min")) {
            this.heapType = heapType;
        }
    }

    /**
     * 带数组的构造函数
     */
    public Heap(int[] arr, int size, String heapType) {

        this.size = size;
        this.heapArr = new int[size + 1];

        if (heapType.equals("min")) {
            this.heapType = heapType;
        }

        this.length = arr.length;
        for (int i = 0; i < this.length; i++) {
            this.heapArr[i + 1] = arr[i];
        }

        for (int i = this.length / 2; i >= 1; i--) {
            this.shiftDown(i);
        }
    }

    public boolean insert(int value) {

        if (this.length >= this.size) {
            return false;
        }

        heapArr[++(this.length)] = value;
        this.shiftUp(this.length);
        return true;
    }


    /*从堆中取出堆顶元素*/
    public int extract() throws Exception {

        if (this.length > 0) {
            int res = heapArr[1];
            this.swap(this.length, 1);
            this.length--;

            if (this.length > 0) {
                this.shiftDown(1);
            }

            return res;
        } else {
            throw new Exception("堆已经为空不能取出数据");
        }

    }

    /**
     * 从给定位置向下调整  使其成为一个堆
     *
     * @param current int 当前要调整的位置
     */
    private void shiftDown(int current) {

        int j;
        while (current * 2 <= length) {

            j = current * 2;

            if (j + 1 <= length && this.compare(this.heapArr[j + 1], this.heapArr[j]) > 0) {
                j++;
            }

            if (this.compare(this.heapArr[j], this.heapArr[current]) > 0) {

                this.swap(current, j);
                current = j;

            } else {
                break;
            }
        }
    }


    /**
     * 从给定位置向上调整  使其成为一个堆
     *
     * @param current int 当前要调整的位置
     */
    private void shiftUp(int current) {

        while (current > 1) {

            if (this.compare(this.heapArr[current], this.heapArr[current / 2]) > 0) {

                this.swap(current, current / 2);
                current = current / 2;
            } else {
                break;
            }

        }
    }


    /**
     * @param a 一个参与比较的对象
     * @param b 一个参与比较的对象
     * @return =0 a=b; >0 a应该在b上面(大顶堆中a>b);<0a应该在b下面
     */
    private int compare(int a, int b) {

        int res;

        if (a == b) {
            res = 0;
        } else {
            res = a > b ? 1 : -1;
        }

        if (this.heapType.equals("min")) {
            res = 0 - res;
        }

        return res;
    }

    /*交换堆中i和j的位置*/
    private void swap(int i, int j) {
        Common.swap(this.heapArr, i, j);
    }

    public int getSize() {
        return this.size;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return this.length <= 0;
    }

    public void printHeap() {

        Common.printArr(this.heapArr, 1, this.length);

    }


}
