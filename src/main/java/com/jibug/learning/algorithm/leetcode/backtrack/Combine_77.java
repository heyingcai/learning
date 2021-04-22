package com.jibug.learning.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 */
public class Combine_77 {

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        if (n == 1) {
            res.add(new ArrayList<>(Collections.singletonList(1)));
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, track, 1, k);
        return res;
    }

    public static void backtrack(int n, LinkedList<Integer> track, int start, int k) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (track.contains(i)) {
                continue;
            }
            track.addLast(i);
            start++;
            backtrack(n, track, start, k);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        System.out.println(combine(1, 1));
    }

}
