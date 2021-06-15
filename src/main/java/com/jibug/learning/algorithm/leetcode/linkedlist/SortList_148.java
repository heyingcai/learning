package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(temp);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
        }
        if (left != null) cur.next = left;
        if (right != null) cur.next = right;
        return dummy.next;
    }
}
