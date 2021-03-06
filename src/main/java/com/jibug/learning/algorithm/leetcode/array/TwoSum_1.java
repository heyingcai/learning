package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dataIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dataIndex.containsKey(target - nums[i])) {
                return new int[]{dataIndex.get(target - nums[i]), i};
            }
            dataIndex.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int[] array = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(array,9)));
    }

}
