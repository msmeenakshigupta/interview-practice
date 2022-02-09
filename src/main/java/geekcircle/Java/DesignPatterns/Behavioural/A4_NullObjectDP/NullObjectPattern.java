package com.geekcircle.Java.DesignPatterns.Behavioural.A4_NullObjectDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface Customer {

    String getName();


}

class RealCustomer implements Customer {

    private String name;


    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

}

class NullCustomer implements Customer {

    @Override
    public String getName() {
        return "Customer Doesn't exist";
    }

}

class CustomerFactory {

    String[] customers = {"A","B"};

    Customer getCustomer(String customer){
        for(String c : customers){
            if(c.equals(customer)){
                return new RealCustomer(c);
            }
        }
        return new NullCustomer();
    }
}

public class NullObjectPattern {
    public static void main(String[] args) {

        CustomerFactory factory = new CustomerFactory();
        Customer a = factory.getCustomer("A");
        Customer c = factory.getCustomer("C");
        System.out.println(c.getName());
    }
}
