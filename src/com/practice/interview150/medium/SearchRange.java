package com.practice.interview150.medium;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int element = -1;
        while(start<end){
            int mid = (start+end)/2;
            if(nums[mid]==target){
                element = mid;
                break;
            }else if(nums[mid]>target){
                end= mid-1;
            }else{
                start = mid+1;
            }
        }
        return findRange(nums,element,target);
    }

    private int[] findRange(int[] nums, int element, int target) {
        if(element==-1)
            return new int[]{-1,-1};
        int start=element, end = element;
        while(start-1>0&&nums[start-1]==target){
            start--;
        }
        while(end+1<nums.length-1&&nums[end+1]==target){
            end++;
        }
        return new int[]{start,end};
    }
}
