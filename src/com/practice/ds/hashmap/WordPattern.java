package com.practice.ds.hashmap;

import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] s_arr = s.split(" ");
        char[] p_arr = pattern.toCharArray();
        HashMap<Character,String> p_map = new HashMap<>();
        HashMap<String,Character> s_map = new HashMap<>();
        if(s_arr.length!=p_arr.length){
            return false;
        }
        else {
            for(int i=0;i<s_arr.length;i++){
                if(p_map.containsKey(p_arr[i])&&!p_map.get(p_arr[i]).equals(s_arr[i])){
                    return false;
                }else if(s_map.containsKey(s_arr[i])&&s_map.get(s_arr[i])!=p_arr[i]){
                    return false;
                }
                s_map.put(s_arr[i],p_arr[i]);
                p_map.put(p_arr[i],s_arr[i]);
            }
        }
        return true;
    }
}
