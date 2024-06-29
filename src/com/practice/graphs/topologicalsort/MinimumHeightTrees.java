package com.practice.graphs.topologicalsort;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if(n==1){
            List<Integer> r= new LinkedList<>();
            r.add(0);
            return r;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
        }
        int[] count = new int[n];

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
            count[a]++;
            count[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.clear();
            int size = queue.size();
            while(size>0){
                int node = queue.poll();
                result.add(node);
                for(int next:graph.get(node)){
                    count[next]--;
                    if(count[next]==1){
                        queue.add(next);
                    }
                }
                size--;
            }
        }
        return result;
    }
}
