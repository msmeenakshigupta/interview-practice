package com.geekcircle.Java.DesignPatterns.Behavioural.A1_StrategyDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Operation {
    int doOperation(int a, int b);
}

class AddOperation implements Operation {
    @Override
    public int doOperation(int a, int b) {
        return a+b;
    }
}

class MultiplyOperation implements Operation {
    @Override
    public int doOperation(int a, int b) {
        return a*b;
    }
}

class Strategy {

    private Operation operation;

    public Strategy(Operation operation) {
        this.operation = operation;
    }

    public int executeOperation(int a, int b){
        return operation.doOperation(a, b);
    }
}


public class StrategyDesignPattern {

    public static void main(String[] args) {
        Strategy strategy = new Strategy(new AddOperation());
        System.out.println("AddOperation : "+ strategy.executeOperation(10, 20));
        strategy = new Strategy(new MultiplyOperation());
        System.out.println("MultiplyOperation : "+ strategy.executeOperation(10, 20));
    }

}
