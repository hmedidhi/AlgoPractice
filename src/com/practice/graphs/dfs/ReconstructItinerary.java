package com.practice.graphs.dfs;

import java.util.*;

public class ReconstructItinerary {

    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> pq = graph.getOrDefault(from, new PriorityQueue<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return  o1.compareTo(o2);
                }
            }));
            pq.add(to);
            graph.put(from, pq);
        }
        generateItinerary(graph, "JFK");
        return result;
    }

    private void generateItinerary(Map<String, PriorityQueue<String>> graph, String source) {
        if (graph.containsKey(source) && graph.get(source).isEmpty())
            return;
        result.add(source);
        PriorityQueue<String> pq = graph.get(source);
        while (!pq.isEmpty()) {
            String newSource = pq.poll();
            graph.put(source, pq);
            generateItinerary(graph, newSource);
        }
        result.addFirst(source);
    }
}
