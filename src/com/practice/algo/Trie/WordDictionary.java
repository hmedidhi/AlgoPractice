package com.practice.algo.Trie;

class WordDictionary {

	class Trie {
		Trie[] children = new Trie[26];
		boolean isWord = false;
	}

	Trie trie;

	/** Initialize your data structure here. */
	public WordDictionary() {
		trie = new Trie();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Trie current = trie;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				current.children[c - 'a'] = new Trie();
			current = current.children[c - 'a'];
		}
		current.isWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot
	 * character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		Trie current = trie;
		return search(current, word, 0);
	}

	private boolean search(Trie current, String word, int pos) {
		for (int i = pos; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == '.') {
				for (Trie trie : current.children) {
					if (trie != null)
						if (search(trie, word, i + 1))
							return true;
				}
				return false;
			}
			if (current.children[c - 'a'] == null)
				return false;
			current = current.children[c - 'a'];
		}
		if (current.isWord)
			return true;
		return false;
	}

	public static void main(String args[]) {

		WordDictionary ws = new WordDictionary();
		ws.addWord("dad");
		ws.addWord("mad");
		ws.addWord("pad");
		System.out.println(ws.search(".ad"));
		// System.out.println(ws.search("da"));
	}
}