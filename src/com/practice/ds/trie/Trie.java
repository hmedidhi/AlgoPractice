package com.practice.ds.trie;

import com.practice.interview150.medium.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Trie {

    private class Node {
        public Node[] children;
        public boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean is_word = false;
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.is_word= true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c:word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.is_word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c:prefix.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */