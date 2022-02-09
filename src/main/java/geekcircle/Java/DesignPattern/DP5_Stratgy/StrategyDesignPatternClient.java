package com.geekcircle.Java.DesignPattern.DP5_Stratgy;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-14
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/
interface Animal {

    Integer getLagCount();

    String getSpeaks();

    String getEats();

    Fly canFly();

}

interface Fly {

    String isAbleToFly();

}

class CanFly implements Fly {

    @Override
    public String isAbleToFly() {
        return "Yes Can Fly";
    }

}

class CannotFly implements Fly {

    @Override
    public String isAbleToFly() {
        return "No Cannot fly.";
    }
}

class Dog implements Animal {


    @Override
    public Integer getLagCount() {
        return 4;
    }

    @Override
    public String getSpeaks() {
        return "Bhow Bhaw";
    }

    @Override
    public String getEats() {
        return "Meat";
    }

    @Override
    public Fly canFly() {
        return new CannotFly();
    }
}

class Cat implements Animal {

    @Override
    public Integer getLagCount() {
        return 4;
    }

    @Override
    public String getSpeaks() {
        return "Meaw Meaw";
    }

    @Override
    public String getEats() {
        return "fish";
    }

    @Override
    public Fly canFly() {
        return new CanFly();
    }
}

public class StrategyDesignPatternClient {
    public static void main(String[] args) {
        Animal cat = new Cat();
        System.out.println(cat.canFly().isAbleToFly());

        cat = new Dog();
        System.out.println(cat.canFly().isAbleToFly());
    }
}
