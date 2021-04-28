package com.jibug.learning.datastructure.linked;


/**
 *
 */
public class ReverseLinked {

    /**
     * 递归反转链表
     *
     * @param node
     * @return
     */
    public static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode lastNode = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return lastNode;
    }



    public static void main(String[] args) {
        ListNode root = new ListNode();
        ListNode two = new ListNode();
        ListNode three = new ListNode();
        three.value=3;
        two.value = 2;
        root.value = 1;
        root.next = two;
        two.next = three;
        reverse(root);
    }
}
