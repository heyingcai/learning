package com.jibug.learning.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        List<Integer> data = new ArrayList<>();
        // 定义四个方向的起点
        int up = 0, down = row - 1, left = 0, right = col - 1;
        while (true) {
            // 从左到右遍历
            for (int i = left; i <= right; i++) {
                data.add(matrix[up][i]);
            }
            // 如果上下一样则退出
            if (++up > down) break;
            // 从上到下遍历
            for (int i = up; i <= down; i++) {
                data.add(matrix[i][right]);
            }
            // 如果右左一样则退出
            if (--right < left) break;
            // 从右到左遍历
            for (int i = right; i >= left; i--) {
                data.add(matrix[down][i]);
            }
            // 如果下上一样则退出
            if (--down < up) break;
            // 从下到上遍历
            for (int i = down; i >= up; i--) {
                data.add(matrix[i][left]);
            }
            // 如果左右一样则退出
            if (++left > right) break;
        }
        return data;
    }
}
