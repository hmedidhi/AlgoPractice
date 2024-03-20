package com.practice.interview150.easy;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String lcp = "";
        String start = strs[0];
        for (int i = 0; i < start.length(); i++) {
            char chr = start.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if((strs[j].length()-1 > i)&&(chr!=strs[j].charAt(i))){
                    return lcp;
                }
            }
            lcp = lcp + chr;
        }
        return lcp;
    }
}
