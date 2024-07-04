package com.practice.ds.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ReplaceWords {

    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isWord = false;
        public String word;
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode cur = root;
        for (Character c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
        cur.word = word;
    }

    public String replacedWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return null;
            }
            cur = cur.children.get(c);
            if (cur.isWord)
                return cur.word;
        }
        return null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary)
            insert(s);
        StringBuilder sb = new StringBuilder();
        String[] strArr = sentence.split(" ");
        for (String str : strArr) {
            String smallString = replacedWord(str);
            sb.append(" ").append(Objects.requireNonNullElse(smallString, str));
        }
        return sb.toString().trim();
    }
}
