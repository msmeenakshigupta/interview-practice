package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-13
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.lang.Enum;

enum Direction {

    EAST("east"),
    WEST("west"),
    NORTH("north"),
    SOUTH("south");

    String value;

    Direction(String value){
        this.value = value;
    }

}

public class EnumExample {
    public static void main(String[] args) {
        System.out.println();
    }
}
