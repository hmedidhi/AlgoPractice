package com.practice.interview150.easy;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0, j = n;
        while (i < n && i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j-1];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
}
