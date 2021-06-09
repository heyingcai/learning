package com.jibug.learning.algorithm.offer;

import com.jibug.learning.datastructure.linked.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint_06 {

    List<Integer> data = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[data.size()];
        }
        recur(head);
        int[] result = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        return result;
    }

    private void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        data.add(head.value);
    }
}
