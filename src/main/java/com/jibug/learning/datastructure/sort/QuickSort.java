package com.jibug.learning.datastructure.sort;

import java.util.Arrays;

/**
 * 快排
 *
 * @author heyingcai
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {1, 45, -2, 9, 3};
        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int midIndex = (left + right) / 2;
        int pivot = array[midIndex];
        int temp;
        while (l < r) {
            while (array[l] < pivot) {
                l += 1;
            }
            while (array[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }

            temp = array[r];
            array[r] = array[l];
            array[l] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (array[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (array[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            sort(array, left, r);
        }

        if (right > l) {
            sort(array, l, right);
        }
    }

}
