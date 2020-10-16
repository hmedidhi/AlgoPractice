package com.practice.algo.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReplaceWords {

	class Trie {
		Trie[] children = new Trie[26];
		String word;
	}

	Trie trie = new Trie();

	private void contructTrie(List<String> dictionary) {
		for (String root : dictionary) {
			Trie current = trie;
			for (char c : root.toCharArray()) {
				if (current.children[c - 'a'] == null)
					current.children[c - 'a'] = new Trie();
				current = current.children[c - 'a'];
			}
			current.word = root;
		}
	}

	public String replaceWords(List<String> dictionary, String sentence) {

		contructTrie(dictionary);
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(replacedWord(word) + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	private String replacedWord(String word) {
		Trie current = trie;
		for (char c : word.toCharArray()) {
			if (current.children[c - 'a'] == null)
				return word;
			current = current.children[c - 'a'];
			if (!Objects.isNull(current.word))
				return current.word;
		}
		return word;
	}

	public static void main(String[] args) {
		String[] words = { "cat", "bat", "rat" };
		List<String> dictionary = new ArrayList<String>();
		for (String word : words)
			dictionary.add(word);
		String sentence = "the cattle was rattled by the battery";
		System.out.println(new ReplaceWords().replaceWords(dictionary, sentence));
	}

}
