package com.geekcircle.Java.SystemDesign.Splitwise.Manager;

import com.geekcircle.Java.SystemDesign.Splitwise.Entity.*;
import com.geekcircle.Java.SystemDesign.Splitwise.Service.ExpenseService;
import com.geekcircle.Java.SystemDesign.Splitwise.Service.UserService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpenseManager {

    UserService userService;
    ExpenseService expenseService;

    public ExpenseManager() {
        this.userService = new UserService();
        this.expenseService = new ExpenseService();
    }

    public boolean addExpense(int paidById, ExpenseType expenseType, double amount, Map<Integer, Double> split){
        //ExpenseType expenseType, double amount, User paidBy, List<Split> splits
        User paidBy = userService.getUser(paidById);
        List<Split> splits = new LinkedList<>();
        if(ExpenseType.EQUAL == expenseType){
            Set<Integer> userIds = split.keySet();
            for(Integer uId : userIds){
                splits.add(new EqualSplit(userService.getUser(uId)));
            }
        } else if(ExpenseType.PERCENT == expenseType ){
            Set<Integer> userIds = split.keySet();
            for(Integer uId : userIds){
                splits.add(new PercentSplit(userService.getUser(uId), split.get(uId)));
            }
        } else if(ExpenseType.EXACT == expenseType){
            Set<Integer> userIds = split.keySet();
            for(Integer uId : userIds){
                splits.add(new ExactSplit(userService.getUser(uId), split.get(uId)));
            }
        }
        expenseService.addExpense(expenseType, amount, paidBy, splits);
        return true;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ExpenseService getExpenseService() {
        return expenseService;
    }

    public void setExpenseService(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
}
