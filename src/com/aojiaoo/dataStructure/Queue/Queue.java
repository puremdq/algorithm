package com.aojiaoo.dataStructure.Queue;

public class Queue<T> {


    private int frontIndex = -1;
    private int rearIndex = 0;
    private int maxSize;//最大容量
    private T[] data;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.frontIndex = -1;
        this.rearIndex = 0;

        this.data = (T[]) new Object[maxSize];
    }

    public Queue(T[] dataArr, int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Object[maxSize];

        if (dataArr.length <= maxSize) {
            for (int i = 0; i < dataArr.length; i++) {
                data[i] = dataArr[i];
            }
            this.frontIndex = 0;
        }
    }

    //入队到队尾
    public boolean enqueue(T value) {

        if (isFull()) {
            return false;
        }

        data[rearIndex] = value;
        this.rearIndex = (this.rearIndex + 1) % this.maxSize;

        if (this.frontIndex == -1) {
            //第一次插入;
            this.frontIndex = 0;
        }
        return true;

    }

    //出队队头
    public T dequeue() {

        T value = this.getFront();
        this.frontIndex = (this.frontIndex + 1) % this.maxSize;
        return value;
    }


    //得到队头不出队
    public T getFront() {

        if (isEmpty()) {
            return null;
        }
        T value = this.data[this.frontIndex];
        return value;
    }

    public boolean isFull() {
        return this.length() == this.maxSize;
    }

    public boolean isEmpty() {
        return this.length() == 0;
    }

    public int length() {

        if (this.frontIndex == -1) {
            return 0;
        }
        return (this.rearIndex - this.frontIndex + this.maxSize) % this.maxSize;
    }

}
