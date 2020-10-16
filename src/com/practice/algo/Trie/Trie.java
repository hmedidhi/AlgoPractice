package com.practice.algo.Trie;

import java.util.HashMap;
import java.util.Map;

class Trie {

	class Triechild {
		Map<Character, Triechild> children = new HashMap<>();
		boolean isWord = false;
	}

	Triechild trie;

	/** Initialize your data structure here. */
	public Trie() {
		trie = new Triechild();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Triechild current = trie;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c))
				current.children.put(c, new Triechild());
			current = current.children.get(c);
		}
		current.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Triechild current = trie;
		for (char c : word.toCharArray()) {
			if (!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return current.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Triechild current = trie;
		for (char c : prefix.toCharArray()) {
			if (!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return true;

	}

	public static void main(String args[]) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */