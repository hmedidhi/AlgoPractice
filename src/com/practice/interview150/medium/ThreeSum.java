package com.practice.interview150.medium;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Set<String> dublicates = new HashSet<>();
        Arrays.sort(nums);
        set.add(nums[0]);
        for (int i = 1; i < nums.length - 1; i++) {
            int j = i+1;
            while(j<nums.length){
                if (set.contains(-1*(nums[i] + nums[j]))) {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    lst.add(-1*(nums[i] + nums[j]));
                    if(!dublicates.contains(lst.toString()))
                        result.add(lst);
                    dublicates.add(lst.toString());
                }
                j++;
                while(j<nums.length&&nums[j-1]==nums[j])
                    j++;
            }
            set.add(nums[i]);
        }
        return result;
    }
}
