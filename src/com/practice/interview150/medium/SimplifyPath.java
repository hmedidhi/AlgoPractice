package com.practice.interview150.medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : strs) {
            if(!s.equals("")){
                if (s.equals("..") || s.equals(".")) {
                    if(s.equals("..")&&!stack.isEmpty())
                        stack.pop();
                }else{
                    stack.push(s);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if(stack.isEmpty())
            return "/";
        while(!stack.isEmpty()){
            result.insert(0, "/" + stack.pop());
        }
        return result.toString();
    }
}
