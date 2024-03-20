package com.practice.interview150.easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("[^a-z0-9]","");
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false; // If characters don't match, it's not a palindrome
            }
            i++;
            j--;
        }

        return true;

    }
}
