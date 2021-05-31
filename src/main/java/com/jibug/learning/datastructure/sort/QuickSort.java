package com.jibug.learning.datastructure.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快排
 *
 * @author heyingcai
 */
public class QuickSort {

    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] array = {1, 45, -2, 9, 3};
        randomQuickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }



    public static void sort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int midIndex = (left + right) / 2;
        int pivot = array[midIndex];
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


            swap(array,r,l);

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

    public static void randomQuickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = randomPartition(nums, left, right);
            randomQuickSort(nums, left, p - 1);
            randomQuickSort(nums, p + 1, right);
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        return partition(nums, left, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int l = left, r = left + 1;
        while (r <= right) {
            if (nums[r] < nums[left]) {
                swap(nums,r, ++l);
            }
            r++;
        }
        swap(nums,left,l);
        return l;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
