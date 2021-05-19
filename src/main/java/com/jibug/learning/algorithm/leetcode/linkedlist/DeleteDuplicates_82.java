package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 *  输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates_82 {

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        // 双指针遍历
        while (curr.next != null && curr.next.next != null) {
            // 如果前后节点的值相等
            if (curr.next.value == curr.next.next.value) {
                // 拿到当前相等的值，继续遍历
                Integer value = curr.next.value;
                while (curr.next != null && curr.next.value == value) {
                    curr.next = curr.next.next;
                }
            }else {
                curr = curr.next;
            }
        }


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l7 = new ListNode(5);
        ListNode l6 = new ListNode(4,l7);
        ListNode l5 = new ListNode(4,l6);
        ListNode l4 = new ListNode(3,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        deleteDuplicates(l1);
    }

}
