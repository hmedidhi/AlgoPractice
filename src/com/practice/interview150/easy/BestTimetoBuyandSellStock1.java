package com.practice.interview150.easy;

public class BestTimetoBuyandSellStock1 {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minValue > price) {
                minValue = price;
            }
            if (price - minValue > maxProfit) {
                maxProfit = price - minValue;
            }
        }

        return maxProfit;
    }
}
