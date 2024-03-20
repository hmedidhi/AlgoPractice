package com.practice.interview150.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i-1]!= nums[i]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
