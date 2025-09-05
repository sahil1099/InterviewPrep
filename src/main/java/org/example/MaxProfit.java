package org.example;

import java.util.Arrays;
import java.util.List;

public class MaxProfit {
    public static void main(String[] args) {
        int money = 20;
        int maxProfit = 0;
        int buy = 0;
        int sell = 0;
        int currentBuy = 0;
        List<Integer> list = Arrays.asList(23, 230, 16, 24, 35, 80, 70, 18, 29, 150, 8, 155, 17);
        //Iterate over element
        for(int i=0; i< list.size(); i++){
            if(money>=list.get(i)){
                currentBuy = list.get(i);
                for(int j=i+1; j< list.size(); j++){
                    int profit = list.get(j)-currentBuy;
                    if(profit>0 && profit>maxProfit){
                        buy = currentBuy;
                        sell = list.get(j);
                        maxProfit = profit;
                    }
                }
            }
        }
        System.out.println("buy at " + buy + " sell at " + sell+ " and maxprofit will be " + maxProfit);
    }
}
