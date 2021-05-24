package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList_143 {

    public void reorderList(ListNode head) {
        // 获取中间节点
        ListNode middleNode = findMiddleNode(head);
        // 需要反转的后半段链表
        ListNode l2 = middleNode.next;
        middleNode.next = null;
        l2 = reverse(l2);
        merge(head, l2);
    }

    /**
     * 合并链表
     *
     * @param l1
     * @param l2
     */
    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l1 = next1;

            l2.next = l1;
            l2 = next2;
        }
    }


    /**
     * 寻找中间节点（偶数链表取第二个中间节点）
     *
     * @param head
     * @return
     */
    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head, slow = head;
        // 返回的是第二个中间节点
        // 如果条件是：fast.next != null && fast.next.next != null，返回的是第一个中间节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }




}
