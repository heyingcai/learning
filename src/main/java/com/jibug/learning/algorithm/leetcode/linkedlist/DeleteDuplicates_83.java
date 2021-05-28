package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 输入：head = [1,1,2,2,3]
 * 输出：[1,2]
 */
public class DeleteDuplicates_83 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.value == cur.next.next.value) {
                Integer value = cur.next.value;
                ListNode temp = cur;
                while (cur.next != null && cur.next.value == value) {
                    cur = cur.next;
                }
                temp.next = cur;
                cur = temp;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    /**
     * 递归
     * 1.明确终止条件是什么
     * 2.找出返回值是什么
     * 3.明确本次要做什么
     *
     * @param head
     * @return
     */
    public static ListNode deleteDup(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDup(head.next);
        if (head.value == head.next.value) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l4 = new ListNode(3);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode l1 = new ListNode(1, l2);

        deleteDup(l1);
    }
}
