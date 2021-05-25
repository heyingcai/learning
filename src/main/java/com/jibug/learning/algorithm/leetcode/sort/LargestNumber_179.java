package com.jibug.learning.algorithm.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * <p>
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * <p>
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestNumber_179 {

    public static String largestNumber(int[] nums) {
//        sort(nums, 0, nums.length - 1);

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }


        Arrays.sort(arr, (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str2.compareTo(str1);
        });

        StringBuilder num = new StringBuilder();
        for (String value : arr) {
            num.append(value);
        }
        if (num.charAt(0) == '0') {
            return "0";
        }
        return num.toString();
    }

    private static void sort(int[] nums, int low, int high) {
        int l = low, r = high;
        if (l >= r) return;
        int pivot = nums[low];
        while (l < r) {
            while (l < r && (nums[l] + "" + pivot).compareTo(pivot + "" + nums[l]) >= 0) {
                l++;
            }
            while (l < r && (nums[r] + "" + pivot).compareTo(pivot + "" + nums[r]) < 0) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }

        nums[low] = nums[l];
        nums[l] = pivot;

        sort(nums, low, l - 1);

        sort(nums, l + 1, high);
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 30, 34, 5, 9};
        System.out.println();
        System.out.println(Arrays.toString(a));
    }




}
