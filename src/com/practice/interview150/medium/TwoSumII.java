package com.practice.interview150.medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(numbers[0], 0);
        for (int i = 1; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])){
                result[0] = map.get(target-numbers[i]);
                result[1] = i;
                return result;
            }else{
                map.put(numbers[i],i);
            }
        }
        return result;
    }
}
