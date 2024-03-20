package com.practice.interview150.easy;

public class IndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int i = 0;
        while (i < (haystack.length() - needle.length() + 1)) {
            int j = 0, k = i;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while (i < haystack.length() && j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == needle.length()) {
                    return k;
                } else {
                    i = k + 1;
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
