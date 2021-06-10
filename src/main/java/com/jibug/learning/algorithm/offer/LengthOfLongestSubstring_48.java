package com.jibug.learning.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dgr0c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring_48 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int start = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, charMap.getOrDefault(s.charAt(i), -1) + 1);
            ans = Math.max(ans, i - start + 1);
            charMap.put(s.charAt(i), i);
        }
        return ans;
    }

}
