package com.jibug.learning.algorithm.leetcode.linkedlist;

import com.jibug.learning.datastructure.linked.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEvenList_328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode oddTail = odd;

        ListNode even = head.next;
        ListNode evenTail = even;
        while (oddTail.next != null && evenTail.next != null) {
            // 移动奇数节点
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            // 移动偶数节点

            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }
        // 奇数的尾节点指向偶数的头节点
        oddTail.next = even;
        return head;
    }
}
