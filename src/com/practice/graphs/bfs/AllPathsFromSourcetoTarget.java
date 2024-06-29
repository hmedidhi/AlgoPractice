package com.practice.graphs.bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        int destination = graph.length - 1;
        Queue<LinkedList<Integer>> queue = new LinkedList<>();
        LinkedList<Integer> entry = new LinkedList<>();
        entry.add(0);
        queue.add(entry);
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = queue.poll();
            if (temp.getLast() == destination) {
                result.add(new LinkedList<Integer>(temp));
            }
            for (int newSource : graph[temp.getLast()]) {
                temp.addLast(newSource);
                queue.add(new LinkedList<Integer>(temp));
                temp.removeLast();
            }
        }
        return result;
    }
}
