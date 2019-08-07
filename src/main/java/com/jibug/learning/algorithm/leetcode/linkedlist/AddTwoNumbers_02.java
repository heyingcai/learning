package com.jibug.learning.algorithm.leetcode.linkedlist;

import static com.jibug.learning.algorithm.leetcode.linkedlist.BaseLinked.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author heyingcai
 * @date 2019-08-06 15:53
 */
public class AddTwoNumbers_02 {

    static class Solution {

        public Solution() {
        }

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //定义新的链表用于保存结果
            ListNode newListNode = new ListNode(0);
            //定义两个指针分别指向两个链表的头节点
            ListNode p = l1, q = l2, currentNode = newListNode;
            //定义变量用于记录上一次计算两个数相加时是否需要进位
            int carry = 0;
            while (p != null || q != null) {
                int x = p != null ? p.value : 0;
                int y = q != null ? q.value : 0;
                //两个链表节点相加
                int sum = x + y + carry;
                //计算是否进位
                carry = sum / 10;
                //将计算结果存入链表
                currentNode.next = new ListNode(sum % 10);
                //链表后移
                currentNode = currentNode.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            //处理最后一次计算的进位
            if (carry > 0) {
                currentNode.next = new ListNode(carry);
            }
            return newListNode.next;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = solution.addTwoNumbers(l1, l2);

        listNode.showLinked();
    }


}
