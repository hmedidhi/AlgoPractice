package com.practice.interview150.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> inputNums = new ArrayList<>();
        for (int x : nums)
            inputNums.add(x);
        backtrack(inputNums, new LinkedList<Integer>());
        return result;
    }

    private void backtrack(List<Integer> inputNums, LinkedList<Integer> subResult) {
        if(inputNums.size()==0){
            result.add(subResult);
            return;
        }
        int size = inputNums.size();
        for(int i=0;i<size;i++){
            int x = inputNums.remove(i);
            subResult.add(x);
            backtrack(inputNums,subResult);
            subResult.removeLast();
            inputNums.add(i,x);
        }
    }
}
