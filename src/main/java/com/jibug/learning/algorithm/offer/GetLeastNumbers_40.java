package com.jibug.learning.algorithm.offer;

import java.util.Arrays;
import java.util.Random;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetLeastNumbers_40 {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,1};
        int[] vec = new int[3];
        Arrays.sort(a);
        for (int i = 0; i < 3; ++i) {
            vec[i] = a[i];
        }
                System.out.println(Arrays.toString(vec));


    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] vec = new int[3];
        for (int i = 0; i < 3; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }

    private static void quickSort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int p = randomPartition(nums, left, right);
            if (p > k) {
                quickSort(nums, left, p - 1, k);
            } else {
                quickSort(nums, p + 1, right, k);
            }
        }
    }

    private static int randomPartition(int[] nums, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, random);
        return parition(nums, left, right);
    }

    private static int parition(int[] nums, int left, int right) {
        int l = left, r = left + 1;
        while (r <= right) {
            if (nums[r] < nums[left]) {
                swap(nums, ++l, r);
            }
            r++;
        }
        swap(nums, l, left);
        return l;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
