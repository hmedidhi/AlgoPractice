package com.practice.interview150.easy;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] rchar = new int[26];
        int[] mchar = new int[26];
        for (int c : ransomNote.toCharArray()) {
            rchar[c - (int) 'a']++;
        }
        for (int c : magazine.toCharArray()) {
            mchar[c - (int) 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (rchar[i] > 0 && rchar[i] > mchar[i])
                return false;
        }
        return true;
    }
}
