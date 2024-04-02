package com.practice.interview150.medium;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private Deque<Integer> deque;
    private Deque<Integer> minStack;

    public MinStack() {
        deque = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        deque.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int minElement = deque.pop();
        if(minElement==minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        return deque.getFirst();
    }

    public int getMin() {
        return minStack.peek();
    }
}