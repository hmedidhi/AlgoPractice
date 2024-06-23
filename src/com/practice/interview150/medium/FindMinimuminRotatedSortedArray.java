package com.practice.interview150.medium;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int x = findStartingPoint(nums, 0, nums.length - 1);
        return Math.max(x, 0);
    }

    private int findStartingPoint(int[] nums, int start, int end) {
        if(end<start)
            return -1;
        int mid = (start+end)/2;
        if(mid-1>0&&nums[mid]<nums[mid-1])
            return mid;
        else{
            int x = findStartingPoint(nums,mid+1,end);
            if(x>0)
                return x;
            else
                return findStartingPoint(nums,start,mid-1);
        }
    }
}
