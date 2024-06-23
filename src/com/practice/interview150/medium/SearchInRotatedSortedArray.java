package com.practice.interview150.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return searchElement(nums,0, nums.length-1,target);
    }

    private int searchElement(int[] nums, int start, int end, int target) {
        if(end<start)
            return -1;
        int midElement = (end+start)/2;
        if(target == nums[midElement]){
            return midElement;
        }
        else if(target<nums[midElement]){
            int x = searchElement(nums,start,midElement-1,target);
            if(x>-1)
                return x;
            else
                return searchElement(nums,midElement+1,end,target);
        }else {
            int x = searchElement(nums,midElement+1,end,target);
            if(x>-1)
                return x;
            else
                return searchElement(nums,start,midElement-1,target);
        }
    }
}
