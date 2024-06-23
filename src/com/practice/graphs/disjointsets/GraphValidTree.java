package com.practice.graphs.disjointsets;

class UnionFind {
    int[] parent;

    UnionFind(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(parent[x]==x)
            return x;
        return find(parent[x]);
    }

    boolean union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX==rootY){
            return false;
        }
        parent[rootX] = rootY;
        return true;
    }
}
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++){
            if(!uf.union(edges[i][0],edges[i][1])){
                return false;
            }
        }
        return true;
    }
}
