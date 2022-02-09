package com.geekcircle.Java.SystemDesign.Splitwise.Service;

import com.geekcircle.Java.SystemDesign.Splitwise.Entity.*;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {

    List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public Expense addExpense(ExpenseType expenseType, double amount, User paidBy, List<Split> splits){
        Expense expense = new Expense(amount, paidBy, splits, expenseType);
        expenses.add(expense);
        expense.maintainGetTake();
        return expense;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }
}
