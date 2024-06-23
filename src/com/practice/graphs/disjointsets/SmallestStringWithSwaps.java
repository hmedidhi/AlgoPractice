package com.practice.graphs.disjointsets;

import java.util.*;

public class SmallestStringWithSwaps {

    class UnionFind {
        int[] roots;
        int[] ranks;
        int count;
        UnionFind(int n){
            count = n;
            roots = new int[n];
            ranks = new int[n];
            for(int i=0;i<n;i++){
                roots[i] = i;
                ranks[i] = i;
            }

        }

        int find(int x){
            if(x!=roots[x])
                x = find(roots[x]);
            return x;
        }

        void union(int x,int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX!=rootY){
                if(ranks[rootX]>ranks[rootY]){
                    roots[rootX] = rootY;
                }else if(ranks[rootX]<ranks[rootY]){
                    roots[rootY] = rootX;
                }else {
                    roots[rootX] = rootY;
                    ranks[rootX]++;
                }
                count--;
            }
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> pair:pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault(p, new PriorityQueue<Character>());
            pq.offer(s.charAt(i));
            map.putIfAbsent(p, pq);
        }
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++)
            cs[i] = map.get(uf.find(i)).poll();
        return new String(cs);
    }

    public static void main(String[] args) {
        SmallestStringWithSwaps a = new SmallestStringWithSwaps();
        Integer[][] lst = {{0,3},{1,2}};
        List<List<Integer>> input = new ArrayList<>();
        for(Integer[] x: lst){
            input.add(Arrays.asList(x));
        }
        a.smallestStringWithSwaps("dcab", input);
    }
}
