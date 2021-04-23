package com.jibug.learning.datastructure.queue;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class StackQueue {

    private Stack<Integer> inputStack;

    private Stack<Integer> outputStack;

    public StackQueue() {
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public void push(Integer value) {
        inputStack.push(value);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        // 如果出队栈有值，则直接返回
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        }
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
        return outputStack.pop();
    }

    public boolean isEmpty() {
        if (inputStack.isEmpty() && outputStack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("入队" + i);
                queue.push(i);
            }
        });


        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.print("出队" + queue.pop());
            }
        });


        t1.start();
        t2.start();

    }

}
