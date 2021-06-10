package com.jibug.learning.algorithm.offer;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/5dy6pt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class PathSum_34 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int target, List<Integer> data) {
        if (node == null) {
            return;
        }
        data.add(node.value);
        target -= node.value;
        if (target == 0 && node.left == null && node.right == null) {
            result.add(new ArrayList<>(data));
        }
        dfs(node.left, target, data);
        dfs(node.right, target, data);
        data.remove(data.size() - 1);
    }
}
