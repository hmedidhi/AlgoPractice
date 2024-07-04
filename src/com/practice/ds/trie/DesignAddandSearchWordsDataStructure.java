package com.practice.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure {

    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
    }

    TrieNode root;

    public DesignAddandSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord=true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        return searchNode(cur, word);
    }

    private boolean searchNode(TrieNode cur, String word) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char c : cur.children.keySet()) {
                        if (searchNode(cur.children.get(c),
                                word.substring(i+1, word.length()))) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                cur = cur.children.get(ch);
            }
        }
        return cur.isWord;
    }

}
