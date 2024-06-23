package com.practice.graphs.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindifPathExistsinGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, LinkedList<Integer>> graph = buildGraph(edges);
        return bfs(graph, source, destination, new boolean[n]);
    }

    private boolean bfs(Map<Integer, LinkedList<Integer>> graph, int source, int destination, boolean[] visited) {
        visited[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true;
            }
            for(int nextNode:graph.get(currNode)){
                if(!visited[nextNode]){
                    visited[nextNode] =true;
                    queue.add(nextNode);
                }
            }
        }
        return false;
    }

    private Map<Integer, LinkedList<Integer>> buildGraph(int[][] edges) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            LinkedList<Integer> lst = map.getOrDefault(edge[0], new LinkedList<>());
            lst.add(edge[1]);
            map.put(edge[0], lst);

            LinkedList<Integer> lst2 = map.getOrDefault(edge[1], new LinkedList<>());
            lst2.add(edge[0]);
            map.put(edge[1], lst2);
        }
        return map;
    }

}
