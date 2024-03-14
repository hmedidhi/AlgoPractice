package com.practice.algo.dynamicprogramming;

public class KnapSackMemorization {
    //Function to return max value that can be put in knapsack of capacity W.
    static int[][] mem;
    static int knapSack(int W, int wt[], int val[], int n)
    {
        mem = new int[n][W+1];
        return knapSackMem(W,wt,val,n);
    }

    static int knapSackMem(int W, int wt[], int val[], int n)
    {
        if(W==0 || n==0){
            return 0;
        }

        if(mem[n-1][W-1]>0){
            return mem[n-1][W-1];
        }

        int x=0;

        if(wt[n-1]<=W)
            x =  val[n-1]+knapSackMem(W-wt[n-1],wt,val,n-1);

        mem[n-1][W-1] = Math.max(x,knapSackMem(W,wt,val,n-1));

        return mem[n-1][W-1];
    }
}
