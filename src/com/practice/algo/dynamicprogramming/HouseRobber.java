package com.practice.algo.dynamicprogramming;

public class HouseRobber {

    int[] dp;
    public int rob(int[] nums) {
        int prev1 = nums[0];
        int prev2 = 0;
        int curi = 0;
        for(int i=1;i<nums.length;i++){
            int pick = nums[i];
            if(i>1)
                pick = pick + prev2;
            int dontpick = prev1;
            curi = Math.max(pick,dontpick);
            prev2 = prev1;
            prev1 = curi;
        }
        return curi;
    }

    private int robUtils(int[] nums, int n) {
        if(n==0)
            return nums[n];
        if(n<0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int pick = nums[n] + robUtils(nums,n-2);
        int dontpick = robUtils(nums, n-1);
        dp[n] = Math.max(pick,dontpick);
        return dp[n];
    }
}
