package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-08
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.ArrayList;
import java.util.List;

public class Stock {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 3, 4, 3 , 50, 60, 90 };
        int k = 2;
        System.out.println(stockProfit(arr, k));
    }

    private static int stockProfit(int[] arr, int k){
        List<Integer> buy = new ArrayList<>();
        List<Integer> sale =new ArrayList<>();
        boolean isBuy = true;
        int i =0;
        for(; i < arr.length-1; i++){
            if(isBuy){
                if(arr[i] < arr[i+1]){
                    buy.add(arr[i]);
                    isBuy = !isBuy;
                }
            } else {
                if(arr[i] >  arr[i+1]){
                    sale.add(arr[i]);
                    isBuy = !isBuy;
                }
            }
        }

        int n = buy.size();
        if(n != sale.size()){
            if(buy.get(n-1) < arr[i]){
                sale.add(arr[i]);
            }
        }

        if(sale.size() > k){

        }

        int profit = 0;
        for(i = 0; i < sale.size(); i++){
            profit += (sale.get(i) - buy.get(i));
        }

        return profit;
    }


    private static void reduceSet(List<Integer> buy, List<Integer> sale, int k){
        List<Integer> newBuy = new ArrayList<>();
        List<Integer> newSale = new ArrayList<>();
        int max = 0;
        int ind = -1;
        while (k != 1){
            for(int i = 0; i < buy.size(); i++){
                if(max < (sale.get(i) - buy.get(i))){
                    max = (sale.get(i) - buy.get(i));
                }
            }
            if(ind != -1){
                newBuy.add(buy.get(ind));
                newSale.add(sale.get(ind));
                buy.remove(ind);
                sale.remove(ind);
            }
            k--;
        }

        for(int i = 0; i < buy.size(); i++){

        }


    }
}
