package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode_106 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(3);

        ListNode d = new ListNode(4, c);

        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode l1 = new ListNode(0, a);

        ListNode l2 = new ListNode(8, d);

        //l1 : 0 -> 1 -> 2 -> 3
        //l2 : 8 -> 4 -> 3
        ListNode intersectionNode = getIntersectionNode(l1, l2);
        System.out.println(intersectionNode.value);
    }


}
