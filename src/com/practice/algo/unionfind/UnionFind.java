package com.practice.algo.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

	Map<Integer, Node> map = new HashMap<>();

	class Node {
		int rank;
		Node parent;
		int data;
	}

	public void makeSet(int data) {
		Node node = new Node();
		node.rank = 0;
		node.data = data;
		node.parent = node;
		map.put(data, node);
	}

	public int findSet(int data) {
		return findSet(map.get(data)).data;
	}

	public Node findSet(Node node) {
		if (node.parent == node) {
			return node;
		}
		node.parent = findSet(node.parent);
		return node.parent;
	}

	public void union(int data1, int data2) {
		Node parent1 = findSet(map.get(data1));
		Node parent2 = findSet(map.get(data2));
		if (parent1 == parent2) {
			return;
		}
		if (parent1.rank >= parent2.rank) {
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
			parent2.parent = parent1;
		} else {
			parent1.parent = parent2;
		}
	}

	public static void main(String[] args) {
		UnionFind uf = new UnionFind();
		uf.makeSet(1);
		uf.makeSet(2);
		uf.makeSet(3);
		uf.makeSet(4);
		uf.makeSet(5);
		uf.makeSet(6);
		uf.makeSet(7);

		uf.union(1, 2);
		uf.union(2, 3);
		uf.union(4, 5);
		uf.union(6, 7);
		uf.union(5, 6);
		uf.union(3, 7);

		System.out.println(uf.findSet(1));
		System.out.println(uf.findSet(2));
		System.out.println(uf.findSet(3));
		System.out.println(uf.findSet(4));
		System.out.println(uf.findSet(5));
		System.out.println(uf.findSet(6));
		System.out.println(uf.findSet(7));
	}

}
