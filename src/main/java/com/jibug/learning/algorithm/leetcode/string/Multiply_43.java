package com.jibug.learning.algorithm.leetcode.string;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply_43 {

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] num1Chars = num1.toCharArray();
        char[] num2Chars = num2.toCharArray();
        int m = num1Chars.length, n = num2Chars.length;
        int carry = 0;
        StringBuilder data;
        String result = null;
        for (int i = m - 1; i >= 0; i--) {
            data = new StringBuilder();
            int x  = num1Chars[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2Chars[j] - '0';
                data.append(((x * y) + carry) % 10);
                carry = ((x * y) + carry) / 10;
            }
            if (carry > 0) {
                data.append(carry);
            }
            if (result == null) {
               result = data.reverse().toString();
            }else {
                data.reverse();
                for (int j = i; j < m - 1; j++) {
                    data.append("0");
                }
                result = addStrings(result, data.toString());
            }
            carry = 0;
        }

        return result;
    }

    private static String addStrings(String num1, String num2) {
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
        String multiply = multiply("0", "52");

        System.out.println(multiply);
    }

}
