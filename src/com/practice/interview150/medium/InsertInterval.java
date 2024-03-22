package com.practice.interview150.medium;

import java.util.ArrayList;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> lst = new ArrayList<>();
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int size = intervals.length;
        while (i < size) {
            if (intervals[i][0] > newInterval[0]) {
                lst.add(newInterval);
                break;
            } else {
                lst.add(intervals[i]);
                i++;
            }
        }
        if(i>=size){
            lst.add(newInterval);
        }
        while (i < size) {
            lst.add(intervals[i]);
            i++;
        }
        i=0;
        size = lst.size();
        while (i < size) {
            int m = lst.get(i)[0];
            int n = lst.get(i)[1];
            int j = i + 1;
            while (j < size) {
                if (lst.get(j)[0] <= n) {
                    n = Math.max(lst.get(j)[1],n);
                } else {
                    break;
                }
                j++;
            }
            i=j;
            result.add(new int[]{m,n});
        }
        if(size==0){
            result.add(new int[]{newInterval[0],newInterval[1]});
        }
        return result.toArray(new int[result.size()][]);
    }
}
