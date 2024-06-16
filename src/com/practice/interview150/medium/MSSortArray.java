package com.practice.interview150.medium;

import java.util.Arrays;

public class MSSortArray {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftptr = 0, rightptr = 0, resultptr = 0;
        while (leftptr < left.length && rightptr < right.length) {
            if (left[leftptr] < right[rightptr]) {
                result[resultptr] = left[leftptr];
                leftptr++;
            }else{
                result[resultptr] = right[rightptr];
                rightptr++;
            }
            resultptr++;
        }
        while(leftptr<left.length){
            result[resultptr] = left[leftptr];
            leftptr++;
            resultptr++;
        }
        while(rightptr<right.length){
            result[resultptr] = right[rightptr];
            rightptr++;
            resultptr++;
        }
        return result;
    }
}
