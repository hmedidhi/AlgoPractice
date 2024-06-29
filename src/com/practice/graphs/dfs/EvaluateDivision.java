package com.practice.graphs.dfs;

import java.util.*;

public class EvaluateDivision {

    class Node {

        private String next;
        private double value;

        Node(String next, double value) {
            this.next = next;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] results = new double[queries.size()];
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);

            List<Node> getNodesA = graph.getOrDefault(a, new LinkedList<>());
            getNodesA.add(new Node(b, values[i]));
            graph.put(a, getNodesA);

            List<Node> getNodesB = graph.getOrDefault(b, new LinkedList<>());
            getNodesB.add(new Node(a, 1 / values[i]));
            graph.put(b, getNodesB);
        }

        for (int j = 0; j < queries.size(); j++) {
            String m = queries.get(j).get(0);
            String n = queries.get(j).get(1);
            if (!graph.containsKey(m) || !graph.containsKey(n)) {
                results[j] = -1;
            } else if (m == n) {
                results[j] = 1;
            } else {
                results[j] = dfs(graph, m, n, new HashSet<String>(), 1);
            }
        }

        return results;
    }

    private double dfs(Map<String, List<Node>> graph, String source, String desination, HashSet<String> visited,
                       double product) {
        visited.add(source);
        double result = -1;
        if(Objects.equals(source, desination))
            return product;
        else{
            for(Node node: graph.get(source)){
                if(visited.contains(node.next))
                    continue;
                result = dfs(graph,node.next,desination,visited,product*node.value);
                if(result!=-1)
                    break;
            }
        }
        visited.remove(source);
        return result;
    }
}
