package com.practice.graphs.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllPathsFromSourcetoTarget {

    List<List<Integer>> results = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        fetchAllPath(graph, 0, graph.length-1, new boolean[graph.length], new LinkedList<Integer>());
        return results;
    }

    private void fetchAllPath(int[][] edges, int source, int destination, boolean[] visited,
                              LinkedList<Integer> result) {
        if(source==destination){
            result.add(destination);
            results.add(new LinkedList<>(result));
            result.removeLast();
            return;
        }
        if(!visited[source]){
            visited[source] = true;
            result.add(source);
            for(int edge: edges[source]){
                fetchAllPath(edges,edge,destination,visited,result);
            }
            result.removeLast();
            visited[source]=false;
        }
    }
}
