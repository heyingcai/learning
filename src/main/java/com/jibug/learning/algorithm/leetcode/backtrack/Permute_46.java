package com.jibug.learning.algorithm.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * <p>
 * 题目：给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permute_46 {

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 当满足条件时加入结果集，并返回
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        List<List<Integer>> permute = permute(a);
        System.out.println(permute);
    }


}
