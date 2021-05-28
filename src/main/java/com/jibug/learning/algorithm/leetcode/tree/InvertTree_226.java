package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 翻转一棵二叉树。
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }

        // 本次做什么？左右子树翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归 左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }
        BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }


}
