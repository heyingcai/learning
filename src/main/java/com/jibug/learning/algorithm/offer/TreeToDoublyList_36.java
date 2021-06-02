package com.jibug.learning.algorithm.offer;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList_36 {

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        dfs(root);
        // 最后的时候头尾连接
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历二叉搜索树返回的是有序数组
     *
     * @param cur
     */
    private void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        // 如果上一个节点为空的话，说明访问的是第一个节点
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }


}
