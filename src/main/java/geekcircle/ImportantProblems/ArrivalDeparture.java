package com.geekcircle.ImportantProblems;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-09
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;

public class ArrivalDeparture {
    public static void main(String[] args) {
        int[] arrival = {1,2,3,3,3};
        int[] departure = {2,2,3,4,4};
        int[] born = {1,1,2};
        int[] death = {1,2,2};

        //System.out.println("Room Allotment Possible: "+maxRoomsRequired(arrival, departure));
        System.out.println("Maximum Celebrity: "+maxCelebrityAlive(born, death));
    }

    private static int maxRoomsRequired(int[] arrival, int[] departure){
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int i = 0;
        int j = 0;
        int current = 0;
        int max = 0;
        while(i < arrival.length && j < departure.length){
            if(arrival[i] <= departure[j]){
                i++;
                current++;
                if(max < current){
                    max = current;
                }
            } else {
                j++;
                current--;
            }
        }
        return max;
    }

    private static int maxCelebrityAlive(int[] born, int[] death){
        Arrays.sort(born);
        Arrays.sort(death);
        int i = 0;
        int j = 0;
        int current = 0;
        int max = 0;
        while(i < born.length && j < death.length){
            if(born[i] <= death[j]){
                i++;
                current++;
                if(max < current){
                    max = current;
                }
            } else {
                j++;
                current--;
            }
        }
        return max;
    }

}
