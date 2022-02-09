package com.geekcircle.Flipkart;

public class A9_GasStation {
    public static void main(String[] args) {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(gasStation(gas, cost));
    }

    private static int gasStation(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            int remaining = 0;
            int j = i;
            boolean reached = false;
            while (true){
                if(gas[j] + remaining - cost[j] >= 0){
                    remaining = gas[j] + remaining - cost[j];
                    j = (j+1) % gas.length;
                    if(j == i){
                        reached = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if(reached){
                return i;
            }
        }
        return -1;
    }
}
