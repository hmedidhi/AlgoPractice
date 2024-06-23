package com.practice.interview150.medium;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int start, int end) {
        if(end==start)
            return start;
        int midElement = (start+end)/2;
        if(nums[midElement]>nums[midElement+1])
            return findPeak(nums, start, midElement);
        else
            return findPeak(nums,midElement+1,end);
    }
}
