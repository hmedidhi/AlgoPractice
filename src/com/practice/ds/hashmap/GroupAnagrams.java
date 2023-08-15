package com.practice.ds.hashmap;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String c_str = Arrays.toString(chars);
            List<String> lst;
            if(map.containsKey(c_str)){
                lst = map.get(c_str);
            }else{
                lst = new ArrayList<>();
            }
            lst.add(str);
            map.put(c_str,lst);
        }
        for(String str : map.keySet()){
            results.add(map.get(str));
        }
        return results;
    }
}
