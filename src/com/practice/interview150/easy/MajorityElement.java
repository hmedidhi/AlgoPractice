package com.practice.interview150.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x: nums){
            if(map.containsKey(x)){
                int val = map.get(x) +1;
                if(val>nums.length/2)
                    return x;
                map.put(x,val);
            }else{
                map.put(x,1);
            }
        }
        return -1;
    }
}
