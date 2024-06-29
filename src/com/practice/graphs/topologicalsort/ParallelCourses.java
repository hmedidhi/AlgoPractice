package com.practice.graphs.topologicalsort;

import java.util.*;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] count = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            count[relation[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<n+1;i++){
            if(count[i]==0)
                queue.add(i);
        }
        int result = 0;
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            while(size-->0){
                int node = queue.poll();
                for(int next:graph.get(node)){
                    count[next]--;
                    if(count[next]==0)
                        queue.add(next);
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(count[i]!=0)
                return -1;
        }
        return result;
    }
}
