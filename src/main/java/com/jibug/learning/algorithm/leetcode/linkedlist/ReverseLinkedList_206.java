package com.jibug.learning.algorithm.leetcode.linkedlist;

import static com.jibug.learning.algorithm.leetcode.linkedlist.BaseLinked.ListNode;

/**
 * 1 → 2 → 3 → 0
 * <p>
 * 0 ← 1 ← 2 ← 3
 *
 * @author heyingcai
 */
public class ReverseLinkedList_206 {

    public static ListNode reverseLinkedList(ListNode listNode) {
        //初始化头结点
        ListNode prev = null;
        ListNode current = listNode;

        while (current != null) {
            //用临时指针保存下一个结点，用于迭代
            ListNode tempNext = current.next;
            //将头结点赋于当前结点的下一个结点
            current.next = prev;
            //更新头结点为当前迭代的结点
            prev = current;
            //将上面临时下一个结点指针赋于当前结点进行迭代
            current = tempNext;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(0);

        //step 1: prev: 1 -> null        linked: 2 -> 3 -> 0 -> null
        //step 2: prev: 2 -> 1 -> null   linked: 3 -> 0 -> null
        //step 3: prev: 3 -> 2 -> null   linked: 0 -> null
        //step 3: prev: 0 -> 3 -> 2 -> 1 -> null   lined : null

        ListNode reverseLinkedList = reverseLinkedList(listNode);


        reverseLinkedList.showLinked();

    }

}
