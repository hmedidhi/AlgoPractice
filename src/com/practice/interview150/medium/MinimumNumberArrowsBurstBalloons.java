package com.practice.interview150.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int i = 0;
        int size = points.length;
        int count = 0;
        while (i < size) {
            int m = points[i][0];
            int n = points[i][1];
            int j = i + 1;
            count++;
            while(j<size){
                if(points[j][0]<=n && points[j][1] >=m){
                    if(points[j][0]>m){
                        m=points[j][0];
                    }
                    if(points[j][1]<n){
                        n=points[j][1];
                    }
                    j++;
                }else {
                    break;
                }
            }
            i = j;
        }
        return count;
    }
}
