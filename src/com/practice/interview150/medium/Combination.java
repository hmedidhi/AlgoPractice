package com.practice.interview150.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        findCombination(n,k,new LinkedList<Integer>());
        return result;
    }

    private void findCombination(int n, int k, LinkedList<Integer> subList) {
        if(k==0){
            result.add(new LinkedList<>(subList));
            return;
        }
        subList.add(n);
        findCombination(n-1,k-1, subList);
        subList.pollLast();
        findCombination(n-1,k, subList);
    }
}
