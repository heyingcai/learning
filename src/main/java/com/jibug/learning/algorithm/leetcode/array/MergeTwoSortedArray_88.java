package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedArray_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0, j = 0, i = 0;
        int[] sort = new int[m + n];
        while (k < m || j < n) {
            // 如果第一个数组的索引已经到最后一个，则直接把第二个数组的原数追加
            if (k == m) {
                sort[i++] = nums2[j];
                j++;
            } else if (j == n) {
                sort[i++] = nums1[k];
                k++;
            } else if (nums1[k] < nums2[j]) {
                sort[i++] = nums1[k];
                k++;
            } else {
                sort[i++] = nums2[j];
                j++;
            }
        }
        for (int l = 0; l < m + n; l++) {
            nums1[l] = sort[l];
        }

    }

    public static void main(String[] args) {

        //[1,2,3,0,0,0]
        //3
        //[2,5,6]
        //3
        //[1]
        //1
        //[]
        //0
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }


}
