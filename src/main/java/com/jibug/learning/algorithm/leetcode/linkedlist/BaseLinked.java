package com.jibug.learning.algorithm.leetcode.linkedlist;

/**
 * @author heyingcai
 */
public class BaseLinked {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public void showLinked() {
            ListNode current = this;
            while (current != null) {
                System.out.print(current.value);
                if (current.next != null) {
                    System.out.print("->");
                }
                current = current.next;
                if (current == null) {
                    System.out.println();
                }
            }
        }
    }

}
