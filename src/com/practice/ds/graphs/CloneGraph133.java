package com.practice.ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {

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

	private Map<Node, Node> marker = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Node newNode = new Node(node.val, new ArrayList<Node>());
		marker.put(node, newNode);
		for (Node ele : node.neighbors) {
			Node newEle = null;
			if (!marker.containsKey(ele))
				newEle = cloneGraph(ele);
			else
				newEle = marker.get(ele);

			newNode.neighbors.add(newEle);
		}
		return newNode;
	}

}
