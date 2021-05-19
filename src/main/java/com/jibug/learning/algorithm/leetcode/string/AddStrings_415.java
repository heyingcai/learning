package com.jibug.learning.algorithm.leetcode.string;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings_415 {

    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int i = num1Chars.length - 1,j = num2Chars.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int first = 0;
            int second = 0;
            if (i >= 0) first = num1Chars[i--] - '0';
            if (j >= 0) second = num2Chars[j--] - '0';
            result.append((carry + first + second) % 10);
            carry = (carry + first + second) / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String checkCode = addStrings("1", "9");
        System.out.println(checkCode);
    }

}

