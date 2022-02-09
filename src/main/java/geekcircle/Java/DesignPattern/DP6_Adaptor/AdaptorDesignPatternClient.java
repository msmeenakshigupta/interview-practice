package com.geekcircle.Java.DesignPattern.DP6_Adaptor;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-14
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/


//Credit card people don't required all details
interface CreditCard {

    String getHolderAccountNumber();

    String getHolderName();

}

class BankDetails {

    public String getAccountNumber(){
        return "00000000000";
    }

    public String getName(){
        return "Akshay";
    }


    public String getAccountType(){
        return "Savings";
    }

    public Integer getMinimumBalance(){
        return 1000;
    }

    public Integer getAccountBalance(){
        return 123000;
    }

}

class BankAdaptorClass extends BankDetails implements CreditCard {

    @Override
    public String getHolderAccountNumber() {
        return getAccountNumber();
    }

    @Override
    public String getHolderName() {
        return getName();
    }
}


public class AdaptorDesignPatternClient {
    public static void main(String[] args) {
        CreditCard creditCard = new BankAdaptorClass();
        System.out.println("Name: " + creditCard.getHolderName() + " And AccountNo: " +creditCard.getHolderAccountNumber());
    }
}
