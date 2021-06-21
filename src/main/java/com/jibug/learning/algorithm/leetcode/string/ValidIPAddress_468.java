package com.jibug.learning.algorithm.leetcode.string;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * <p>
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * IPv4 地址由十进制数和点来表示，每个地址包含 4 个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 * <p>
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 * <p>
 * IPv6 地址由 8 组 16 进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 * <p>
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 * <p>
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：IP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 示例 2：
 * <p>
 * 输入：IP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidIPAddress_468 {

    public static void main(String[] args) {
        String checkCode = validIPAddress("1.0.1.");
        System.out.println(checkCode);

    }

    public static String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPV4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPV6(IP);
        } else {
            return "Neither";
        }
    }

    public static String validateIPV4(String IP) {
        if (IP.charAt(IP.length()-1) == '.') return "Neither";
        String[] nums = IP.split("\\.");
        for (String num : nums) {
            if (num.length() == 0 || num.length() > 3) return "Neither";
            if (num.charAt(0) == '0' && num.length() != 1) return "Neither";
            for (char ch : num.toCharArray()) {
                if (!Character.isDigit(ch)) return "Neither";
            }
            if (Integer.parseInt(num) > 255) return "Neither";
        }
        return "IPv4";
    }

    public static String validateIPV6(String IP) {
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x : nums) {
            if (x.length() == 0 || x.length() > 4) return "Neither";
            for (Character ch : x.toCharArray()) {
                if (hexdigits.indexOf(ch) == -1) return "Neither";
            }
        }
        return "IPv6";
    }


}
