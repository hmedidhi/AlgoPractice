package com.practice.algo.dynamicprogramming;

public class PartitionEqualSubsetSum {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num:nums)
            totalSum = totalSum +num;
        if(totalSum%2!=0)
            return false;
        dp = new Boolean[nums.length+1][(totalSum/2)+1];
        return checkPartiton(nums,nums.length-1,totalSum/2);
    }

    private boolean checkPartiton(int[] nums, int n, int sum) {
        if(sum==0)
            return true;
        if(n<0)
            return false;
        if(dp[n][sum]!=null)
            return dp[n][sum];
        if(nums[n]<=sum){
            dp[n][sum]= checkPartiton(nums,n-1,sum-nums[n]) || checkPartiton(nums,n-1,sum);
        }else{
            dp[n][sum]= checkPartiton(nums,n-1,sum);
        }
        return dp[n][sum];
    }
}
