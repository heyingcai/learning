package com.jibug.learning.algorithm.leetcode.linkedlist;

/**
 * @author 003613 heyingcai
 * @date 2020-09-11 17:10
 */
public class PalindromeLinkedList_234 {

    public static boolean isPalindrome(BaseLinked.ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        BaseLinked.ListNode slow = head, fast = head;
        BaseLinked.ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.value != slow.value) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindrome_2(BaseLinked.ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        BaseLinked.ListNode slow = head, fast = head;
        // fast指针多走一步
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // slow 当前是第一个中间节点
        BaseLinked.ListNode nextHead = slow.next;
        BaseLinked.ListNode reverse = reverse(nextHead);
        BaseLinked.ListNode cur = head;
        while (cur != null && reverse != null) {
            if (cur.value != reverse.value) {
                return false;
            }
            cur = cur.next;
            reverse = reverse.next;
        }
        return true;
    }

    private static BaseLinked.ListNode reverse(BaseLinked.ListNode node) {
        BaseLinked.ListNode prev = null;
        BaseLinked.ListNode cur = node;
        while (cur != null) {
            BaseLinked.ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        BaseLinked.ListNode listNode = new BaseLinked.ListNode(1);
        listNode.next = new BaseLinked.ListNode(2);
        listNode.next.next = new BaseLinked.ListNode(2);
        listNode.next.next.next = new BaseLinked.ListNode(1);

        boolean palindrome = isPalindrome_2(listNode);

        System.out.println(palindrome);

    }

}

