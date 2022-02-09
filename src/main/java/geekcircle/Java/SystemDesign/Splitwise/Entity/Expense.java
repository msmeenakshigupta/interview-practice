package com.geekcircle.Java.SystemDesign.Splitwise.Entity;

import java.util.List;

public  class Expense {

    private double amount;

    private User paidBy;

    List<Split> splits;

    ExpenseType type;

    public Expense(double amount, User paidBy, List<Split> splits, ExpenseType type) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.type = type;
    }

    public boolean maintainGetTake(){

        switch (this.type){
            case PERCENT:{
                for(Split split : splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    if(paidBy.getId() == percentSplit.getUser().getId()){
                        paidBy.setGet(paidBy.getGet() + (amount - (percentSplit.getPercent() * amount)/100));
                    } else {
                        percentSplit.getUser().setGive(percentSplit.getUser().getGive() + (percentSplit.getPercent() * amount)/100);
                    }
                }
                break;
            }
            case EQUAL: {
                double amt = this.amount/splits.size();
                for(Split split : splits){
                    EqualSplit equalSplit = (EqualSplit) split;
                    if(paidBy.getId() == equalSplit.getUser().getId()){
                        paidBy.setGet((splits.size() - 1) * amt);
                    } else {
                        equalSplit.getUser().setGive(equalSplit.getUser().getGive() + amt);
                    }
                }
                break;
            }

            case EXACT:{
                for(Split split : splits){
                    ExactSplit exactSplit = (ExactSplit) split;
                    if(paidBy.getId() == exactSplit.getUser().getId()){
                        paidBy.setGet(paidBy.getGet() + exactSplit.getAmount());
                    } else {
                        exactSplit.getUser().setGive(exactSplit.getUser().getGive() + exactSplit.getAmount());
                    }
                }
                break;
            }
        }
        return true;
    }
}