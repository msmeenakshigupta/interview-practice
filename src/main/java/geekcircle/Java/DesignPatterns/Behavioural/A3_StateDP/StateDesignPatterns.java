package com.geekcircle.Java.DesignPatterns.Behavioural.A3_StateDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface State {

    void doAction(Order order);

}

class Start implements State {

    @Override
    public void doAction(Order order) {
        System.out.println("State Change to Start");
        order.setState(this);
    }

    @Override
    public String toString() {
        return "Start{}";
    }
}

class End implements State {

    @Override
    public void doAction(Order order) {
        System.out.println("State Change to End");
        order.setState(this);
    }

    @Override
    public String toString() {
        return "End{}";
    }
}

class Order {

    State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

public class StateDesignPatterns {
    public static void main(String[] args) {
        Order order = new Order();
        State state = new Start();
        state.doAction(order);
        state = new End();
        state.doAction(order);
    }
}
