package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class SwapPairs_24 {

    /**
     * 递归解决
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 记录与当前节点交换的节点
        ListNode next = head.next;
        // 当前节点指向交换好的链表
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

}
