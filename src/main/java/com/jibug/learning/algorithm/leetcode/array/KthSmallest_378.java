package com.jibug.learning.algorithm.leetcode.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthSmallest_378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(11, Comparator.comparingInt(o -> o[0]));
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            // int[实际值, 行索引，列索引]
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        while (k != 0) {
            int[] cur = queue.poll();
            k--;
            int num = cur[0];
            if (k == 0) {
                return num;
            }
            // 列值
            if (cur[2] != col - 1) {
                // 列 + 1
                int index = cur[2] + 1;
                queue.offer(new int[]{matrix[cur[1]][index], cur[1], index});
            }
        }
        return -1;
    }

    public static void main(String[] args) {


    }

}
