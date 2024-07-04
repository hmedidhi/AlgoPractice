package com.practice.algo.dynamicprogramming;

public class LIS {

    int[][] dp;

    public int lengthOfLIS2(int[] nums) {
        dp = new int[nums.length][nums.length+1];

        for (int i = 0; i < nums.length; i++)
            for(int j=0;j< nums.length+1;j++)
                dp[i][j] = -1;

        return lis(nums, -1, 0);
    }

    public int lengthOfLIS(int[] nums) {
       return 0;
    }

    private int lis(int[] nums, int prev, int index) {

        if (index == nums.length)
            return 0;

        if(dp[index][prev+1]!=-1)
            return dp[index][prev+1];

        int len = lis(nums, prev, index + 1);

        if (prev == -1 || nums[index] > nums[prev])
            len = Math.max(len, 1 + lis(nums, index, index + 1));

        dp[index][prev+1] = len;
        return len;
    }
}
