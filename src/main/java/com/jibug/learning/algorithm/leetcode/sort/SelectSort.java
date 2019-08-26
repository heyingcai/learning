package com.jibug.learning.algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author heyingcai
 */
public class SelectSort {

    public static void sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = 1 + i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    array[j] = min;
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {19, 2, 40, 23};

        sort(array);

        System.out.println(Arrays.toString(array));
    }

}
