package com.practice.graphs.disjointsets;

import java.util.HashSet;

public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int[] roots = new int[isConnected.length];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    performUnion(roots, i, j);
                }
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for (int root : roots) set.add(root);
        return set.size();
    }

    private int find(int x,int[] roots){
        if(x == roots[x])
            return x;
        x = find(roots[x],roots);
        return x;
    }
    private void performUnion(int[] roots, int i, int j) {
        int rootx = find(i,roots);
        int rooty = find(j,roots);
        if(rootx != rooty)
            roots[rooty] = rootx;
    }
}
