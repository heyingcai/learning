package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }

            // 把下一个待翻转的首节点保存
            ListNode next = end.next;
            // 当前需要翻转的断开
            end.next = null;

            // 当前需要翻转的首节点
            ListNode start = prev.next;
            // 将需要翻转的首节点传入翻转函数，并将prev指向已经翻转的链表
            prev.next = reverse(start);

            // 此时start节点已经被翻转到最后了，因为之前已经断开了，所以需要重新连上后面的节点
            start.next = next;
            // 重新定义新的prev
            prev = start;
            // 重新定义新的end
            end = start;

        }

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
