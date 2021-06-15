package com.jibug.learning.algorithm.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid_20 {

    public static void main(String[] args) {
        System.out.println(isValid("{{}}"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character,Character> pattern = new HashMap<>();
        pattern.put('}', '{');
        pattern.put(')', '(');
        pattern.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pattern.containsKey(c)) {
                if (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pattern.get(c) != pop) {
                        stack.push(c);
                    }
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
