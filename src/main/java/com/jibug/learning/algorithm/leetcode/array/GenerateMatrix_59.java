package com.jibug.learning.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 */
public class GenerateMatrix_59 {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, up = 0, down = n - 1, right = n - 1;
        int index = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = index++;
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = index++;
            }
            if (--right < left) break;
            for (int i = right; i >= left ; i--) {
                matrix[down][i] = index++;
            }
            if (--down < up) break;
            for (int i = down; i >= up ; i--) {
                matrix[i][left] = index++;
            }
            if (++left > right) break;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(ints[i]));

        }
    }

}
