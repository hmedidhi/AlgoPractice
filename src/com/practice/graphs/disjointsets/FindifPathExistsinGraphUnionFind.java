package com.practice.graphs.disjointsets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FindifPathExistsinGraphUnionFind {

    class UnionFind{
        int[] roots;
        int[] ranks;
        UnionFind(int n){
            roots = new int[n];
            ranks = new int[n];
            for(int i=0;i<n;i++){
                roots[i]= i;
                ranks[i]= i;
            }
        }

        int find(int val){
            if(val!=roots[val])
                val = find(roots[val]);
            return val;
        }

        void union(int a,int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootB!=rootA){
                if (ranks[rootA] > ranks[rootB]) {
                    int tmp = rootA;
                    rootA = rootB;
                    rootB = tmp;
                }
                roots[rootA] = rootB;
                ranks[rootB] += ranks[rootA];
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf =new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0],edge[1]);
        }
        return uf.find(source) == uf.find(destination);
    }
}
