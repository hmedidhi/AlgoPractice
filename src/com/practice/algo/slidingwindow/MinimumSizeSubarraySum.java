package com.practice.algo.slidingwindow;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int prevSum = 0;
        int result = Integer.MAX_VALUE;
        int size = nums.length;
        int start = 0;
        int initial = 0;
        while (start < size) {
            while (prevSum < target && start < size) {
                prevSum = prevSum + nums[start];
                start = start + 1;
            }
            while (prevSum >= target) {
                result = Math.min(result, start - initial);
                prevSum = prevSum - nums[initial];
                initial = initial + 1;
            }
        }
        if (result != Integer.MAX_VALUE)
            return result;
        return 0;
    }

    public int minSubArrayLen_BrutForce(int target, int[] nums) {
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    if (result > j - i + 1) {
                        result = j - i + 1;
                    }
                    break;
                }
            }
        }
        if (result != Integer.MAX_VALUE)
            return result;
        return 0;
    }
}
