package com.practice.algo.Trie;

import java.util.HashMap;
import java.util.Map;

class MapSum {

	Map<String, Integer> map;

	class Trie {
		Map<Character, Trie> children = new HashMap<>();
		int val = 0;
	}

	Trie trie;

	/** Initialize your data structure here. */
	public MapSum() {
		trie = new Trie();
		map = new HashMap<>();
	}

	public void insert(String key, int val) {
		Trie current = trie;
		int diff = val - map.getOrDefault(key, 0);
		map.put(key, val);
		for (char c : key.toCharArray()) {
			if (!current.children.containsKey(c))
				current.children.put(c, new Trie());
			current = current.children.get(c);
			current.val = current.val + diff;
		}
	}

	public int sum(String prefix) {
		Trie current = trie;
		for (char c : prefix.toCharArray()) {
			if (!current.children.containsKey(c))
				return 0;
			current = current.children.get(c);
		}
		return current.val;
	}

	public static void main(String args[]) {
		MapSum ms = new MapSum();
		ms.insert("aa", 3);
		System.out.println(ms.sum("a"));
		ms.insert("aa", 2);
		System.out.println(ms.sum("a"));
	}
}