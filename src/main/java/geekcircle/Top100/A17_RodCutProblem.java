package com.geekcircle.Top100;

import com.geekcircle.Utility;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

public class A17_RodCutProblem {
    public static void main(String[] args) {
        int[] weight = {9,9,9,9,9,9,9,9,9};
        int[] price = {1,2,3,4,5,6,7,8,9};
        int rodLength = 5;
        rodCutTree(weight, price, weight.length-1, rodLength, "", 0, rodLength);
        //System.out.println(rodCutOptimized(weight, price, rodLength));
        //System.out.println(rodCut(price,5));
        if(list.isEmpty()){
            System.out.println(-1);
        }
        System.out.println(list);
    }


    private  static  List<Integer> list = new LinkedList<>();
    private  static  int max = -1;
    private static void rodCutTree(int[] weight, int[] price, int n, int w, String str, int sum, int ow){

        if(w == 0){
            if(max < sum){
                max = sum;
                list = new LinkedList<>();
                String[] ss = str.split("");
                if(ss.length == ow){
                    for(int i = 0; i < ss.length; i++){
                        if(list.size() > i){
                            list.set(i, price[Integer.parseInt(ss[i])-1]);
                        } else {
                            list.add(price[Integer.parseInt(ss[i])-1]);
                        }
                    }
                }
            }

            return;
        }

        if(n >= 0) {
            if((w - weight[n]) >= 0){
                rodCutTree(weight, price, n-1,w - weight[n], weight[n]+""+str, sum+price[n], ow);
                rodCutTree(weight, price, n,w - weight[n], weight[n]+""+str, sum+price[n], ow);
            }
            rodCutTree(weight, price, n-1,w, "", sum, ow);
        }
    }

    private static int rodCutOptimized(int[] weight, int[] price, int rodLength){
        int max = 0;
        int[][] lookup = new int[weight.length+1][rodLength+1];
        for(int i = 1; i < price.length; i++){
            for(int j = 1; j < rodLength+1; j++){
                if(j >= weight[i-1]){
                    int remaining = j - weight[i-1];
                    lookup[i][j] = price[i-1] + lookup[i][remaining];
                    if(max < lookup[i][j]){
                        max = lookup[i][j];
                    }
                } else {
                    lookup[i][j] = lookup[i][j-1];
                }
            }
        }
        for(int i = 0; i < price.length; i++) {
            System.out.println(Arrays.toString(lookup[i]));
        }
        return max;


    }

    public static int rodCut(int[] price, int n)
    {
        // T[i] stores maximum profit achieved from rod of length i
        int[] T = new int[n + 1];

        // consider rod of length i
        for (int i = 1; i <= n; i++)
        {
            // divide the rod of length i into two rods of length j
            // and i-j each and take maximum
            for (int j = 1; j <= i; j++) {
                T[i] = Integer.max(T[i], price[j - 1] + T[i - j]);
            }
        }

        // T[n] stores maximum profit achieved from rod of length n
        return T[n];
    }
}
