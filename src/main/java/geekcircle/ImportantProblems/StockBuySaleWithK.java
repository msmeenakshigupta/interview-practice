package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-08
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StockBuySaleWithK {
    public static void main(String[] args) {
        int[] arr = {2, 4, 7, 5, 4, 3, 5};
        int k = 2;
        //System.out.println(maxProfit(arr, k));
        System.out.println(buySell(arr, k));
    }

    private static int maxProfit(int[] prices, int k){
        int n = prices.length;
        int[][] profits = new int[k + 1][n];

        for(int i = 1; i < k+1; i++){
            for(int j = 1; j < n; j++){

                //1. Do BuySell
                int buySell = 0;
                //check buy on 0 -> j-1
                for(int l = 0; l < j; l++){

                    //Profit from jth sell with buy 0 -> j-1 buy
                    int sellProfit = prices[j] - prices[l];
                    int profitBefore = profits[i-1][l];
                    int current = sellProfit + profitBefore;
                    if(current > buySell){
                        buySell = current;
                    }
                }

                //2. Don't Do Buy Sell
                int noBuySell = profits[i][j-1];

                profits[i][j] = Integer.max(buySell, noBuySell);
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(prices[i]+" ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < k+1; i++){
            for(int j = 0; j < n; j++){
                System.out.print(profits[i][j]+" ");
            }
            System.out.println();
        }
        return profits[k][n-1];
    }


























    private static int buySell(int[] prices, int k){
        int n = prices.length;
        int[][] profit = new int[k + 1][n];

        //Run For K = 0 -> k
        for(int i = 1; i < k+1; i++){

            //Run for 0th to n-1 prices
            for(int j = 1; j < n; j++){

                //Buy and Sell
                int buySale = 0;
                for(int l = 0; l < j; l++){
                    buySale = Integer.max((prices[j] - prices[l]) + profit[i-1][l], buySale);
                }

                //Don't sell
                int dontsell = profit[i][j-1];

                profit[i][j] = Integer.max(buySale, dontsell);
            }
        }
        return profit[k][n-1];
    }
}
