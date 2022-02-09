package com.geekcircle.Top100;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-26
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.Arrays;
import java.util.stream.Stream;

public class A28_LargestNumberFormFromListOfNumbers {
    public static void main(String[] args) {
        String[] arr = {"10","68","97","9","21","12"};
        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));
        Stream.of(arr).forEach(System.out::print);
    }
}
