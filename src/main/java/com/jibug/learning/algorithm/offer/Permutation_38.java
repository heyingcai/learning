package com.jibug.learning.algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dfv5h/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Permutation_38 {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("aaab")));
    }

    public static String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars,new StringBuilder(),new boolean[s.length()]);
        String[] data = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            data[i] = result.get(i);
        }
        return data;
    }

    private static void backtrack(char[] chars,  StringBuilder append, boolean[] used) {
        if (append.length() == chars.length) {
            result.add(append.toString());
            return;
        }

        for (int j = 0; j < chars.length; j++) {
            if (used[j]) {
                continue;
            }
            // 剪枝
            if (j > 0 && chars[j] == chars[j-1] && !used[j - 1]) {
                continue;
            }
            append.append(chars[j]);
            used[j] = true;
            backtrack(chars, append,used);
            append.deleteCharAt(append.length() - 1);
            used[j] = false;
        }

    }
}
