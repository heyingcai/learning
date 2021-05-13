package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InorderTraversal_94 {

    List<Integer> data = new ArrayList<>();

    Deque<TreeNode> stack = new ArrayDeque<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return data;
    }

    /**
     * 递归遍历
     *
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        data.add(root.value);
        inorder(root.right);
    }

    /**
     * 迭代遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null && !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            data.add(curr.value);
            curr = curr.right;
        }
        return data;
    }

    public static void main(String[] args) {

    }

}
