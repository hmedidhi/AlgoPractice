package com.practice.graphs.disjointsets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EarliestMomentWhenEveryoneBecomeFriends {

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

        boolean union(int x,int y){
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
                return count == 1;
            }
            return false;
        }
    }
    class Log {
        int timestamp;
        int nodeA;
        int nodeB;

        Log(int timestamp, int nodeA, int nodeB) {
            this.timestamp = timestamp;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        for(int[] log: logs){
            if(uf.union(log[1],log[2])){
                return log[0];
            }
        }
        return -1;
    }
}
