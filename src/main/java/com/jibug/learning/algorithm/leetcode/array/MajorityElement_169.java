package com.jibug.learning.algorithm.leetcode.array;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement_169 {

    /**
     * 方法一：排序后，nums[nums.length/2]
     * 方法二：摩尔排序
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int canNum = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                canNum = nums[i];
                count++;
                continue;
            }
            if (nums[i] == canNum) {
                count++;
            }else {
                count--;
            }
        }
        return canNum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(a));
    }

}
