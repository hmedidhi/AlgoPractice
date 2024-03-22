package com.practice.interview150.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int length = nums.length;
        while (i < length) {
            int j = i;
            while (j + 1 < length && ((nums[j] + 1) == (nums[j + 1]))) {
                j++;
            }
            if (j > i) {
                result.add(nums[i]+"->"+nums[j]);
                i= j+1;
            } else {
                result.add(""+nums[i]);
                i++;
            }

        }
        return result;
    }
}
