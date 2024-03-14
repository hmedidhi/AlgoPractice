package com.practice.algo.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int initial = 0;
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
            if (!set.contains(charArray[i])) {
                set.add(charArray[i]);
            } else {
                while (set.contains(charArray[initial]) && i > initial) {
                    set.remove(charArray[initial]);
                    initial++;
                    if(charArray[initial-1]==charArray[i])
                        break;
                }
                set.add(charArray[i]);
            }
            result = Math.max(result, set.size());
            System.out.println(result);
        }
        return result;
    }
}
