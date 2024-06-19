package com.practice.interview150.medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    List<String> result = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder str = new StringBuilder();
        backtrack(n, str, 0,0);
        return result;
    }

    private void backtrack(int n, StringBuilder str, int leftCount, int rightCount) {
        if (str.length()==2*n) {
            result.add(str.toString());
            return;
        }
        if(leftCount>n){
            str.append("(");
            backtrack(n,str,leftCount+1,rightCount);
            str.deleteCharAt(str.length()-1);
        }
        if(leftCount>rightCount){
            str.append(")");
            backtrack(n,str,leftCount,rightCount+1);
            str.deleteCharAt(str.length()-1);
        }
    }
}
