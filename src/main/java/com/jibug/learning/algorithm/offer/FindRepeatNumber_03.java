package com.jibug.learning.algorithm.offer;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/59bjss/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FindRepeatNumber_03 {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            // 如果当前索引对应的值已经存在了，证明找到重复的数字了
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }

            // 交换
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;

        }
        return -1;
    }
}
