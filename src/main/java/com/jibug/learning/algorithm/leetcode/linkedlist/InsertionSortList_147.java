package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 *
 */
public class InsertionSortList_147 {

    public static ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;


        ListNode lastSorted = head, curr = head.next;


        while (curr != null) {
            if (lastSorted.value <= curr.value) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.value <= curr.value) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(3);
        ListNode l3 = new ListNode(1,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(4,l2);

        ListNode listNode = insertionSortList(l1);
        System.out.println(listNode);

    }
}
