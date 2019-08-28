package com.jibug.learning.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author heyingcai
 */
public class BubbleSort {

    public static void sort(int[] array) {
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp;
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 10};
        sort(array);
    }

}
