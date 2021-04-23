package com.jibug.learning.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class GenerateParenthesis_22 {

    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, 0, 0);
        return result;
    }

    public static void backtrack(StringBuilder res, int n, int left, int right) {
        if (res.length() == 2 * n) {
            result.add(res.toString());
            return;
        }

        // 左括号添加的条件是，当前左括号的数量小于n，则添加左括号
        if (left < n) {
            backtrack(res.append("("), n, left + 1, right);
            res.deleteCharAt(res.length() - 1);
        }
        // 右括号的添加条件：左括号的数量要大于右括号
        if (left > right) {
            backtrack(res.append(")"), n, left, right + 1);
            res.deleteCharAt(res.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
