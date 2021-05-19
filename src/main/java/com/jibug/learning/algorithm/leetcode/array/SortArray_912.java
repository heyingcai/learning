package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 */
public class SortArray_912 {

    public static void main(String[] args) {
        int[] a = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(sortArray(a)));
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length -1 , new int[nums.length]);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[t] = nums[l];
                l++;
                t++;
            }else {
                temp[t] = nums[r];
                r++;
                t++;
            }
        }
        while (l <= mid) {
            temp[t++] = nums[l++];
        }
        while (r <= right) {
            temp[t++] = nums[r++];
        }

        for (int i = 0; i < t; i++) {
            nums[left + i] = temp[i];
        }
    }


}
