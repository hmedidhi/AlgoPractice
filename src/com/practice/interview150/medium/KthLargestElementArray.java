package com.practice.interview150.medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for(int x:nums){
            pq.add(x);
        }
        int x = 0;
        System.out.println(pq.size());
        while(!pq.isEmpty()&&k>0){
            x= pq.remove();
            k--;
        }

        return x;
    }
}
