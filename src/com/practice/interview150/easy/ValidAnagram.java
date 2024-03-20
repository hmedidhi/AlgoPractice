package com.practice.interview150.easy;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charSet= new int[26];
        if(s.length()!=t.length())
            return false;
        for(char c: s.toCharArray()){
            charSet[c - (int)'a']++;
        }
        for(char c: t.toCharArray()){
            if(charSet[c - (int)'a']==0)
                return false;
            charSet[c - (int)'a']--;
        }
        return true;
    }
}
