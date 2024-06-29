package com.practice.interview150.medium;

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3){
            return nums.length;
        }

        int j=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[j-2]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
