package com.jibug.learning.algorithm.leetcode.array;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search_33 {

    public static void main(String[] args) {
        int[] a = new int[]{4, 5, 6, 7, 0, 1, 2};
        int search = search(a, 0);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 中间值和左区间值在同一个区间内
            if (nums[mid] >= nums[l]) {
                // 如果中间值大于目标值 并且 中间值大于或等于左边值，则缩小 右区间
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                }
                // 如果目标值大于中间值或者 目标值小于左边值，则缩小 左区间
                else if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                }
            }
            // 中间值和左边值不在一个区域
            else if (nums[mid] < nums[l]) {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else if (nums[mid] > target || target > nums[r]) {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}
