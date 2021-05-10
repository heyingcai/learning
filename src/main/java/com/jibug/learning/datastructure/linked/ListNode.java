package com.jibug.learning.datastructure.linked;

/**
 *
 */
public class ListNode {

    public Integer value;

    public ListNode next;

    public ListNode(Integer value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public ListNode(Integer value) {
        this.value = value;
    }

    public ListNode() {
    }
}
