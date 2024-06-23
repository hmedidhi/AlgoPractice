package com.practice.graphs.disjointsets;

class UnionFindConnectedComponents {
    int[] roots;
    int[] ranks;
    int count;
    UnionFindConnectedComponents(int n){
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
            x = find(x);
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
public class NumberOfConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        UnionFindConnectedComponents uf  = new UnionFindConnectedComponents(n);
        for(int[] edge : edges){
            int edgeA = edge[0];
            int edgeB = edge[1];
            uf.union(edgeA,edgeB);
        }
        return uf.count;
    }
}
