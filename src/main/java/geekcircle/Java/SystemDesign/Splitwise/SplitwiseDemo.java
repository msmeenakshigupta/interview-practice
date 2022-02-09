package com.geekcircle.Java.SystemDesign.Splitwise;

import com.geekcircle.Java.SystemDesign.Splitwise.Entity.ExpenseType;
import com.geekcircle.Java.SystemDesign.Splitwise.Manager.ExpenseManager;
import com.geekcircle.Java.SystemDesign.Splitwise.Service.UserService;

import java.util.LinkedHashMap;
import java.util.Map;

public class SplitwiseDemo {

    static ExpenseManager expenseManager = new ExpenseManager();

    public static void main(String[] args) {
        expenseManager.getUserService().addUser(1, "Akshay");
        expenseManager.getUserService().addUser(2, "Shankar");
        expenseManager.getUserService().addUser(3, "Allu");
        Map<Integer, Double> split = new LinkedHashMap<>();
        split.put(1,100.0);
        split.put(2,70.0);
        split.put(3,30.0);
        expenseManager.addExpense(1, ExpenseType.EXACT, 200, split);

        System.out.println(expenseManager.getExpenseService().getExpenses());
    }
}
