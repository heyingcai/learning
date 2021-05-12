package com.jibug.learning.algorithm.leetcode.search;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearch_704 {

    /**
     * 递归查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 迭代查找
     *
     * @param left
     * @param right
     * @param nums
     * @param target
     * @return
     */
    public static int binary(int left, int right, int[] nums, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                return binary(mid + 1, right, nums, target);
            } else {
                return binary(left, mid - 1, nums, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(array, 12));
        System.out.println(binary(0, array.length - 1, array, 12));
    }

}
