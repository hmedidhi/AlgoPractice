package com.practice.interview150.medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String x : tokens) {
            if (x.equals("+") ||x.equals("-") || x.equals("*") || x.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (x) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> stack.push(a / b);
                }
            }else{
                stack.push(Integer.parseInt(x));
            }
        }
        return stack.peek();
    }

}
