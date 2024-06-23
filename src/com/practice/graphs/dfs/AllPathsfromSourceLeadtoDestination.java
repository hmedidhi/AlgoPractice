package com.practice.graphs.dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AllPathsfromSourceLeadtoDestination {


    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            LinkedList<Integer> lst = graph.getOrDefault(edge[0], new LinkedList<>());
            lst.add(edge[1]);
            graph.put(edge[0], lst);
        }
        return checkDestination(graph, source, destination, new boolean[n], new boolean[n]);
    }

    private boolean checkDestination(Map<Integer, LinkedList<Integer>> graph, int source, int destination, boolean[] visited, boolean[] checkLoop) {
        if (checkLoop[source])
            return false;

        if (!graph.containsKey(source))
            return source == destination;

        visited[source] = true;
        checkLoop[source] = true;
        for (Integer newSouce : graph.get(source)) {
            boolean isReached = !visited[newSouce] || checkDestination(graph, newSouce, source, visited, checkLoop);
            if (!isReached)
                return false;
        }
        checkLoop[source] = false;
        return true;
    }
}
