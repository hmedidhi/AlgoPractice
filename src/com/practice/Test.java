package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Test {
    int total = 0;
    public int numTrees(int n) {
        List<Integer> inputList = new ArrayList<>();
        for(int i=1;i<=n;i++)
            inputList.add(i);
        numTreesUtils(inputList,n);
        return total;
    }

    private void numTreesUtils(List<Integer> lst,int n){
        if(n==0){
            total = total + 1;
            return;
        }
        for (int root : lst) {
            List<Integer> temp = lst;
        }
    }
}
