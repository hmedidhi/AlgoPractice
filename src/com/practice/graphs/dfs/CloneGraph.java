package com.practice.graphs.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        return cloneNode(node, map);
    }

    private Node cloneNode(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node parentNode = new Node(node.val, new ArrayList<>());
        map.put(node, parentNode);
        ArrayList<Node> childNodes = (ArrayList<Node>) parentNode.neighbors;
        for (Node childNode : node.neighbors)
            childNodes.add(cloneNode(childNode, map));
        return parentNode;
    }

}
