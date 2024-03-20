package com.practice.interview150.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            int sum = 0;
            while(n!=0){
                int x = n%10;
                sum= sum + (x*x);
                n = n/10;
            }
            n = sum;
            if(n==1)
                return true;
        }
        return false;
    }
}
