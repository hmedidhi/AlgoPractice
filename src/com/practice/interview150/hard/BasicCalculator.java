package com.practice.interview150.hard;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        int i = s.length() - 1;
        System.out.println(i);
        Stack<String> stack = new Stack<>();
        while (i>=0) {
            if (s.charAt(i) != '(' && s.charAt(i) != ' ') {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == '(') {
                while(stack.peek().equals(")")){
                    int a = Integer.parseInt(stack.pop());
                    String op = stack.pop();
                    int b = Integer.parseInt(stack.pop());
                    System.out.println(a + " " + b);
                    switch (op) {
                        case "+" -> stack.push(String.valueOf(a + b));
                        case "-" -> stack.push(String.valueOf(a - b));
                    }
                }
                stack.pop();
            }
            i--;
        }
        while (stack.size() > 1) {
            int a = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int b = Integer.parseInt(stack.pop());
            System.out.println(a + " " + b);
            switch (op) {
                case "+" -> stack.push(String.valueOf(a + b));
                case "-" -> stack.push(String.valueOf(a - b));
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
