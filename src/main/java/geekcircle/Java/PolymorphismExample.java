package com.geekcircle.Java;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-07
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

class Vehicle {

    public void numberOfWheels(){
        System.out.println("No Definition Defined");
    }

}

class FourWheeler extends Vehicle {

    @Override
    public void numberOfWheels() {
        System.out.println("4 Wheels");
    }

}

class TwoWheeler extends Vehicle {

    @Override
    public void numberOfWheels() {
        System.out.println("2 Wheels");
    }

}

public class PolymorphismExample {

    public static void main(String[] args) {
        Vehicle vehicle = new TwoWheeler();
        vehicle.numberOfWheels();
    }

}
