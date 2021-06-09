package com.jibug.learning.algorithm.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: MyStack_225.java
 * @Package com.jibug.learning.algorithm.leetcode.stack
 * @Description:
 * @Author: 0003613 heyingcai
 * @Date: 2021-06-07 15:18
 * @Version V1.0
 * @License: Copyright Since 2015 Hive Box Technology. All rights reserved.
 * @Notice: This content is limited to the internal circulation of Hive Box, and it is prohibited to leak or used for other commercial purposes.
 */
public class MyStack_225 {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = this.queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(123 % 10);
        int x = -123;
        int n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        System.out.println(n);
    }
}
