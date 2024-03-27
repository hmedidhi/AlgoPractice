package com.practice.interview150.medium;

public class JumpGameII {

    int minJumps = Integer.MAX_VALUE;
    int[] leastJumps;

    public int jump(int[] nums) {
        leastJumps = new int[nums.length];
        for (int i = 0; i < leastJumps.length; i++) {
            leastJumps[i] = Integer.MAX_VALUE;
        }
        jumpUtils(nums, 0, 0);
        return minJumps;
    }

    private void jumpUtils(int[] nums, int index, int jumps) {
        leastJumps[index] = jumps;
        ;
        if (index == nums.length - 1) {
            minJumps = Math.min(jumps, minJumps);
        }
        for (int i = 1; i <= nums[index] && index + i < nums.length; i++) {
            if (leastJumps[index + i] > jumps + 1) {
                jumpUtils(nums, index + i, jumps + 1);
            }
        }
    }
}
