package com.jibug.learning.algorithm.leetcode.tree;

import com.jibug.learning.datastructure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree_105 {

    public static void main(String[] args) {
        BuildTree_105 build = new BuildTree_105();
        build.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    private int preOrderIdx;
    private int[] preorder;
    private Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrderIdx = 0;
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }


        return build(0, preorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = preorder[preOrderIdx];
        TreeNode root = new TreeNode(rootValue);
        preOrderIdx++;

        Integer p = idxMap.get(rootValue);
        root.left = build(left, p - 1);
        root.right = build(p + 1, right);
        return root;
    }

}
