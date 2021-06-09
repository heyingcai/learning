package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;

/**
 *
 */
public class SortedSquares_977 {

    public static void main(String[] args) {
        int[] a = new int[]{-1};
        System.out.println(Arrays.toString(sortedSquares(a)));

    }

    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int negative = -1;
        // 先找到分界点
        for (int i = 0; i < length; i++) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }
        int[] result = new int[nums.length];
        int index = 0, l = negative, r = negative + 1;
        // 然后合并分界点两边的值，类似归并排序那样
        while (l >= 0 && r <= length - 1) {
            int leftNum = nums[l] * nums[l];
            int rightNum = nums[r] * nums[r];
            if (leftNum <= rightNum) {
                result[index++] = leftNum;
                l--;
            }else {
                result[index++] = rightNum;
                r++;
            }
        }
        while (l >= 0) {
            result[index++] = nums[l] * nums[l];
            l--;
        }
        while (r <= length-1) {
            result[index++] = nums[r] * nums[r];
            r++;
        }
        return result;
    }
}
