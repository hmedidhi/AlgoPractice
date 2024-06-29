package com.practice.graphs.topologicalsort;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder();
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.put(c, new LinkedList<>());
                count.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j), count.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char c:count.keySet()){
            if(count.get(c)==0)
                queue.add(c);
        }
        while(!queue.isEmpty()){
            char c = queue.poll();
            result.append(c);
            for(Character next : graph.get(c)){
                count.put(next, count.get(next) - 1);
                if (count.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (result.length() < count.size()) {
            return "";
        }
        return result.toString();
    }
}
