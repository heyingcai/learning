package com.jibug.learning.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 */
public class CombinationSum_39 {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, track, target, 0);
        return result;
    }

    private static void backtrack(int[] candidates, List<Integer> track, int remains, int start) {
        // 结束条件
        if (remains < 0) return;
        if (remains == 0) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > remains) break;
            track.add(num);
            backtrack(candidates, track, remains - num, i);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 6, 7};
        List<List<Integer>> lists = combinationSum(array, 7);
        System.out.println(lists);
    }

}
