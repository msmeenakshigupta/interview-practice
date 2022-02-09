package com.geekcircle.Microsoft;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-18
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

public class A2_IsBinaryIsMultipleOf3 {
    public static void main(String[] args) {
        String binary = "0110";
        int odd = 0;
        int even = 0;
        boolean isOdd = true;
        for(int i = binary.length()-1; i >= 0; i--){
            if(isOdd && binary.charAt(i) == '1'){
                odd++;
            } else if (!isOdd && binary.charAt(i) == '1') {
                even++;
            }
            isOdd = !isOdd;
        }
        System.out.println("ODD: "+odd+" EVEN: "+even);
        System.out.println((Math.abs(odd - even) % 3 == 0) ? "Yes" : "No");
    }
}
