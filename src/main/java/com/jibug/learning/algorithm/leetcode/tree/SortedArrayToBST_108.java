package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private TreeNode recur(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recur(nums, l, mid - 1);
        root.right = recur(nums, mid + 1, r);
        return root;
    }
}
