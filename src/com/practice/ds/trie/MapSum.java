package com.practice.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String,Integer> sum = new HashMap<>();

    }

    TrieNode root;

    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            cur.sum.put(key,val);
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return 0;
            }
            cur = cur.children.get(c);
        }
        int sum = 0;
        for(int val: cur.sum.values())
            sum += val;
        return sum;
    }
}
