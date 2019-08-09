package com.jibug.learning.algorithm.leetcode.linkedlist;

import static com.jibug.learning.algorithm.leetcode.linkedlist.BaseLinked.ListNode;

/**
 * @author heyingcai
 */
public class MergeTwoSortedLinked_21 {

    public static ListNode mergeTwoLists_recursion(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.value < l2.value) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1);

        ListNode prev = newList;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return newList.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);

        ListNode listNode = mergeTwoLists(l1, l2);
        listNode.showLinked();
    }

}
