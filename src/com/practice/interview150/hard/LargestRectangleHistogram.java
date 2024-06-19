package com.practice.interview150.hard;

import java.util.Stack;

public class LargestRectangleHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while(stack.peek()!=-1 && heights[stack.peek()]>heights[i]){
                int area = heights[stack.pop()] * (i-stack.peek()-1);
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        while(stack.peek()!=-1){
            int currentHeight = heights[stack.pop()];
            int area = currentHeight * (n-stack.peek()-1);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
