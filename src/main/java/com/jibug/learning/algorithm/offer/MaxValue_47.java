package com.jibug.learning.algorithm.offer;

/**
 * 礼物的最大价值
 */
public class MaxValue_47 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 第一个格子的值就是初始值，最大值就是当前值，直接忽略
                if (i == 0 && j == 0) continue;
                // i == 0的情况，说明是从左到右的情况，则只需取前一列的值
                if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                // j== 0的情况，说明是从上到下的情况，则只需取上一个行的值
                else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                // 对角的情况，需要取列和行的最大值
                else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
