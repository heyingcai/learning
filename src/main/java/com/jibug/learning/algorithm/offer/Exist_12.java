package com.jibug.learning.algorithm.offer;

/**
 * 矩阵中的路径
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58wowd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58wowd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Exist_12 {

    static boolean exist = false;

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i , j, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'F','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean abcced = exist(board, "ABCCED");
        System.out.println(abcced);
    }


    private static boolean dfs(char[][] board, int i, int j, char[] chars, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != chars[k]) {
            return false;
        }

        if (k == chars.length - 1) return true;

        board[i][j] = '\0';

        boolean result = dfs(board, i + 1, j, chars, k+1)
                || dfs(board, i, j + 1, chars, k+1)
                || dfs(board, i - 1, j, chars, k+1)
                || dfs(board, i, j - 1, chars, k+1);

        board[i][j] = chars[k];
        return result;
    }

}
