package com.jibug.learning.algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * @author heyingcai
 */
public class InsertSort {

    public static void sort(int[] array) {
        int insertVal;
        int insertIndex;

        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 45, -2, 9, 3};
        sort(array);

        System.out.println(Arrays.toString(array));
    }

}
