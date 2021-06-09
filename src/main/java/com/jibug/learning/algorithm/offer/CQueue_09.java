package com.jibug.learning.algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CQueue_09 {

    private Deque<Integer> inputStack;
    private Deque<Integer> outputStack;

    public CQueue_09() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        inputStack.push(value);
    }

    public int deleteHead() {
        if (outputStack.isEmpty() && inputStack.isEmpty()) {
            return -1;
        }else {
            if (!outputStack.isEmpty()) {
                return outputStack.pop();
            }
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
            return outputStack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue_09 queue_09 = new CQueue_09();
        queue_09.appendTail(3);
        System.out.println(queue_09.deleteHead());
        System.out.println(queue_09.deleteHead());
    }

}
