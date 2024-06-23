package com.practice.interview150.medium;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return searchElement(nums,0,nums.length-1,target);
    }

    private int searchElement(int[] nums, int start, int end, int target) {
        if(end<start)
            return start;
        int midElement = (start+end)/2;
        if(nums[midElement]==target)
            return midElement;
        else if(target<nums[midElement])
            return searchElement(nums, start,midElement-1,target);
        else
            return searchElement(nums,midElement+1,end,target);
    }
}
