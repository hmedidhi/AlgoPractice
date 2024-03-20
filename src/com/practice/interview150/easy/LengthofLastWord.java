package com.practice.interview150.easy;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String[] strArr = s.trim().split(" ");
        return strArr[strArr.length-1].length();
    }
}
