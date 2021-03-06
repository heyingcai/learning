package com.jibug.learning.datastructure.tree;


public class TreeNode {

    public Integer value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
