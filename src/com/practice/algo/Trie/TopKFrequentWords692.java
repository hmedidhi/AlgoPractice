package com.practice.algo.Trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords692 {

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		return null;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
