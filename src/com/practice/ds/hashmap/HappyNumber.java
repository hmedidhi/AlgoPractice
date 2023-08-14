package com.practice.ds.hashmap;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n>1){
            char[] chr_n = String.valueOf(n).toCharArray();
            int sum =0;
            for(char x: chr_n){
                sum = sum + Character.getNumericValue(x)*Character.getNumericValue(x);
            }
            n = sum;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
        return n == 1;
    }
}
