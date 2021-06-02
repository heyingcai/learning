package com.jibug.learning.algorithm.offer;

import java.util.Random;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinNumber_45 {

    public static void main(String[] args) {
        int[] a = new int[]{3,30,34,5,9};
        System.out.println(minNumber(a));
    }

    public static String minNumber(int[] nums) {
        quick(nums, 0, nums.length - 1);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            num.append(nums[i]);
        }
        return num.toString();
    }

    private static void quick(int[] nums, int left, int right) {
        if (left < right) {
            int random = new Random().nextInt(right - left + 1) + left;
            swap(nums, left, random);
            int partition = partition(nums, left, right);
            quick(nums, left, partition - 1);
            quick(nums, partition + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int l = left, r = left + 1;
        while (r <= right) {
            String x = nums[r] + "" + nums[left];
            String y = nums[left] + "" + nums[r];
            // 21 > 12 xy > yx ? y 放在 x 前面
            if (x.compareTo(y) < 0) {
                swap(nums, ++l, r);
            }
            r++;
        }
        swap(nums, l, left);
        return l;
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
