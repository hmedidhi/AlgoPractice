package com.practice.graphs.dfs;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindifPathExistsinGraph {

    boolean result = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for(int[] edge:edges){
            LinkedList<Integer> lst =  map.getOrDefault(edge[0],new LinkedList<>());
            lst.add(edge[1]);
            map.put(edge[0],lst);

            LinkedList<Integer> lst2 =  map.getOrDefault(edge[1],new LinkedList<>());
            lst2.add(edge[0]);
            map.put(edge[1],lst2);
        }
        checkPath(map, source, destination, visited);
        return result;
    }

    private boolean checkPath(Map<Integer, LinkedList<Integer>> edges, int source, int destination, boolean[] visited) {
        if(source==destination) {
            return true;
        }
        if(visited[source]){
            visited[source]= true;
            for(int edge:edges.get(source)){
                return checkPath(edges,edge,destination,visited);
            }
        }
        return false;
    }
}
