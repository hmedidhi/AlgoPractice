package com.practice.interview150.hard;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxTrappedWater = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i-stack.peek()-1;
                int bounded_height =  Math.min(height[stack.peek()],height[i]) - height[top];
                maxTrappedWater = maxTrappedWater+ (distance * bounded_height);

            }
            stack.push(i);
        }
        return maxTrappedWater;
    }
}
