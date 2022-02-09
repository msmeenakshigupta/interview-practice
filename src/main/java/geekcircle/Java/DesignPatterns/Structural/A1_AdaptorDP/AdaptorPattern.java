package com.geekcircle.Java.DesignPatterns.Structural.A1_AdaptorDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-16
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

interface CreditCard {

    String getCustomerName();

    String getContactDetails();

}

class BankAccount {

    private String name = "Akshay";

    private String mobileNumber = "8858886252";

    private Double balance = 2000.0;

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Double getBalance() {
        return balance;
    }

}

class CreditCardImpl extends BankAccount implements CreditCard {

    @Override
    public String getCustomerName() {
        return getName();
    }

    @Override
    public String getContactDetails() {
        return getMobileNumber();
    }
}

public class AdaptorPattern {

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCardImpl();
        System.out.println("Name: "+ creditCard.getCustomerName()+" MobileNo: "+creditCard.getContactDetails());
    }

}
