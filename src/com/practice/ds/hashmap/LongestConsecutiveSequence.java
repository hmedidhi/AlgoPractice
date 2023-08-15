package com.practice.ds.hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxElement = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        for(int x:nums){
            int up =x-1;
            int down =x+1;
            int count =0;
            set.remove(x);
            while(set.contains(up)) {
                count++;
                set.remove(up);
                up--;
            }
            while(set.contains(down)) {
                count++;
                set.remove(down);
                down++;
            }
            if(maxElement<(count+1))
                maxElement = count+1;

        }
        return maxElement;
    }
}
