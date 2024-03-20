package com.practice.interview150.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int value = 0;
        char prev = '#';
        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if(map.get(cur)<map.getOrDefault(prev,0)){
                value = value - map.get(cur);
            }else{
                value = value + map.get(cur);
            }
            prev = cur;
        }
        return value;
    }
}
