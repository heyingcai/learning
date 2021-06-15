package com.jibug.learning.algorithm.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5v8a6t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Exchange_21 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                swap(nums,j,i);
                i++;
            }
            j++;
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
