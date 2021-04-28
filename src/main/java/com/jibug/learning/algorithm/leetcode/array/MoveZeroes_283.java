package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 */
public class MoveZeroes_283 {

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return;
        }
        int slow = 0,fast = 0;
        while (fast != length) {
            if (nums[fast] != 0) {
                swap(slow,fast,nums);
                slow++;
            }
            fast++;
        }
    }

    private static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
