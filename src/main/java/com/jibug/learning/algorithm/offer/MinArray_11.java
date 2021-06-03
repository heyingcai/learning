package com.jibug.learning.algorithm.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinArray_11 {

    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 如果右边的值大于中间的值，说明分界点在mid的左边
            if (numbers[mid] < numbers[high]) {
                high = mid;
            }else if (numbers[mid] > numbers[high]) {
                // 如果中间值大于右边值，说明分界点在mid右边
                low = mid + 1;
            }else {
                // 如果中间值和右边一样，则右边往左移
                high--;
            }
        }
        return numbers[low];
    }

}
