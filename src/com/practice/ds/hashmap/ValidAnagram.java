package com.practice.ds.hashmap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] chr_arr= new int[26];
        for(char x: s.toCharArray()){
            chr_arr[(int)x - 97]++;
        }
        for(char x: t.toCharArray()){
            chr_arr[(int)x - 97]--;
        }
        for(int x: chr_arr){
            if(x!=0)
                return false;
        }
        return true;
    }
}
