package com.jibug.learning.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 */
public class MinStack_155 {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack_155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        }else {
            if (minStack.peek() < val) {
                minStack.push(minStack.peek());
            }else {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return 0;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        //["MinStack","push","push","push","getMin","pop","top","getMin"]
        //[[],[-2],[0],[-3],[],[],[],[]]
        //[null,null,null,null,-3,null,0,-2]
        MinStack_155 minStack_155 = new MinStack_155();
//        minStack_155.push(-2);
//        minStack_155.push(0);
//        minStack_155.push(-3);
//        System.out.println(minStack_155.getMin());
//        minStack_155.pop();
//        System.out.println(minStack_155.top());
//        System.out.println(minStack_155.getMin());

        //["MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[512],[-1024],[-1024],[512],[],[],[],[],[],[]]
        minStack_155.push(512);
        minStack_155.push(-1024);
        minStack_155.push(-1024);
        minStack_155.push(512);
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
        minStack_155.pop();
        System.out.println(minStack_155.getMin());
    }
}
