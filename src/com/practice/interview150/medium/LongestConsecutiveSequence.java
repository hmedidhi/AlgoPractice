package com.practice.interview150.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            int count = 0;
            if (set.contains(x)) {
                set.remove(x);
                int val = x;
                while (set.contains(--val)) {
                    count++;
                    set.remove(val);
                }
                val = x;
                while (set.contains(++val)) {
                    count++;
                    set.remove(val);
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
