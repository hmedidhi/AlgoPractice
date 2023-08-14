package com.practice.ds.hashmap;

import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        HashMap<Character,Character> s_map = new HashMap<>();
        HashMap<Character,Character> t_map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            System.out.println(s_arr[i]);
            System.out.println(t_arr[i]);
            if(s_map.containsKey(s_arr[i])
                    &&s_map.get(s_arr[i])!=t_arr[i]){
                return false;
            }
            if(t_map.containsKey(t_arr[i])
                    &&t_map.get(t_arr[i])!=s_arr[i]){
                return false;
            }
            s_map.put(s_arr[i],t_arr[i]);
            t_map.put(t_arr[i],s_arr[i]);
        }
        return true;
    }
}
