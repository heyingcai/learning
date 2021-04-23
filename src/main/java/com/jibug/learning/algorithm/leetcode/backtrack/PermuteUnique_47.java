package com.jibug.learning.algorithm.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 * <p>
 * 题目：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 */
public class PermuteUnique_47 {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        // 用于剪枝
        Arrays.sort(nums);
        backtrack(nums, track, new boolean[nums.length]);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 当满足条件时加入结果集，并返回
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 2};
        List<List<Integer>> permute = permute(a);
        System.out.println(permute);
    }


}
