package com.geekcircle.Java.DesignPatterns.Behavioural.A2_ObserverDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.LinkedHashSet;
import java.util.Set;

//System
class Publisher {

    Set<Subscriber> subscribers = new LinkedHashSet<>();

    //If state Change inform all subscribers
    private int state;

    int getState() {
        return state;
    }

    void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    boolean subscribe(Subscriber subscriber){
        try {
            subscribers.add(subscriber);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean unsubscribe(Subscriber subscriber){
        try {
            if(subscribers.contains(subscriber)){
                subscribers.remove(subscriber);
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private void notifyAllObservers(){
        for(Subscriber subscriber : subscribers){
            subscriber.update();
        }
    }

}


interface Subscriber {

    void update();

    void subscribe();

    void unsubscribe();

}

class Subscriber1 implements Subscriber {

    private Publisher publisher;

    Subscriber1(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void update() {
        System.out.println("Subscriber 1 "+ publisher.getState());
    }

    @Override
    public void subscribe() {
        this.publisher.subscribe(this);
    }

    @Override
    public void unsubscribe() {
        this.publisher.unsubscribe(this);
    }
}

class Subscriber2 implements Subscriber {

    private Publisher publisher;

    Subscriber2(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void update() {
        System.out.println("Subscriber 2 "+ publisher.getState());
    }

    @Override
    public void subscribe() {
        this.publisher.subscribe(this);
    }

    @Override
    public void unsubscribe() {
        this.publisher.unsubscribe(this);
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Subscriber ob1 = new Subscriber1(publisher);
        Subscriber ob2 = new Subscriber2(publisher);
        ob1.subscribe();
        publisher.setState(1);
        ob2.subscribe();
        publisher.setState(2);
        ob1.unsubscribe();
        publisher.setState(3);
        ob2.unsubscribe();
        publisher.setState(4);

    }
}
