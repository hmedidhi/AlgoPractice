package com.practice.interview150.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Set<String> dublicates = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length - 1; i++) {
            if (set.contains(-1*(nums[i] + nums[i + 1]))) {
                List<Integer> lst = new ArrayList<>();
                lst.add(nums[i]);
                lst.add(nums[i+1]);
                lst.add(-1*(nums[i] + nums[i + 1]));
                lst = lst.stream().sorted().toList();
                if(dublicates.contains(lst.toString()))
                    result.add(lst);
                dublicates.add(lst.toString());
            }
            set.add(nums[i]);
        }
        return result;
    }
}
