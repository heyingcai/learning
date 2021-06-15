package com.jibug.learning.algorithm.offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58iqo5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MissingNumber_53 {

    public static void main(String[] args) {
        int[] a = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(a));
    }

    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == mid) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

}
