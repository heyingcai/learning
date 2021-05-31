package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder_103 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int depth = 1;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty() || !stack.isEmpty()) {
            int size = depth % 2 != 0 ? queue.size() : stack.size();
            List<Integer> data = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                // 奇数
                if (depth % 2 != 0) {
                    TreeNode node = queue.poll();
                    data.add(node.value);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }else {
                    // 偶数
                    TreeNode node = stack.pop();
                    data.add(node.value);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            depth++;
            result.add(data);
        }
        return result;
    }

}
