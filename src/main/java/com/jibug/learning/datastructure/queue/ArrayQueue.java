package com.jibug.learning.datastructure.queue;

/**
 * @author heyingcai
 * @date 2020-02-27 11:46
 */
public class ArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        array = new int[this.maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int data) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }

        rear++;

        array[rear] = data;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        }
        for (int i = front; i < rear; i++) {
            System.out.printf("array[%d]=%d \n", i, array[i]);
        }
    }
}
