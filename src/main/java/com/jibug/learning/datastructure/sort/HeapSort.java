package com.jibug.learning.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = new int[]{4,6,8,5,9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static void sort(int[] arr) {

        // 1.构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        // 2.调整结构
        for (int i = arr.length - 1; i > 0; i--) {
            // 将堆顶元素和最后的值交换
            swap(arr, 0, i);
            // 然后重新调整
            adjust(arr, 0, i);
        }
    }

    public static void adjust(int[] arr, int parent, int length) {
        // 将父节点保存起来
        int temp = arr[parent];
        // 父节点的子节点索引
        int child = 2 * parent + 1;

        while (child < length) {
            // 如果右子节点大于左子节点，则用右边的来判断
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 如果父节点已经大于孩子节点，则直接结束
            if (temp > arr[child]) {
                break;
            }
            // 把子节点的值赋给父节点
            arr[parent] = arr[child];

            // 然后将此子节点作为父节点，继续找他的子节点继续找
            parent = child;
            child = 2 * child + 1;
        }

        // 最后更新交换的值
        arr[parent] = temp;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

