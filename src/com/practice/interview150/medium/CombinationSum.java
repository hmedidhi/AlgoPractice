package com.practice.interview150.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CombinationSum {

    List<List<Integer>> results = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,new LinkedList<Integer>(),0);
        return results;
    }

    private void backtrack(int[] candidates, int target, LinkedList<Integer> subList,int start) {
        if(target==0){
            results.add(new LinkedList<>(subList));
            return;
        }
        if(target<0)
            return;
        for(int i=start;i<candidates.length;i++){
            subList.add(candidates[i]);
            backtrack(candidates,target-candidates[i],subList,i);
            subList.removeLast();
        }
    }
}
