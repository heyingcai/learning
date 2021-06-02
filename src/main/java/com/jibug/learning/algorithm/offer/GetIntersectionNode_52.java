package com.jibug.learning.algorithm.offer;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class GetIntersectionNode_52 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
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
