package com.practice.interview150.medium;

import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> lsts = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int i = 0;
        int length = intervals.length;
        while (i < length) {
            int m = intervals[i][0];
            int n = intervals[i][1];
            int j = i + 1;
            while (j < length) {
                if (intervals[j][0] <= n) {
                    n = Math.max(intervals[j][1],n);
                } else {
                    break;
                }
                j++;
            }
            i=j;
            lsts.add(new int[]{m,n});
        }
        return lsts.toArray(new int[lsts.size()][]);
    }
}
