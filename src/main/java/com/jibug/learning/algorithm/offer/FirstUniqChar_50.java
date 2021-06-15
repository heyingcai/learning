package com.jibug.learning.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 50000
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5viisg/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class FirstUniqChar_50 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
