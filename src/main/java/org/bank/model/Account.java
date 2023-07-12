package org.bank.model;

import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.NonPositiveException;

public class Account {
    private double balance;


    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if(amount <= 0){
            throw new NonPositiveException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
    }
    public void withdraw(double amount) {
        if(amount <= 0){
            throw new NonPositiveException("Withdrawal amount must be greater than zero.");
        }
        if(this.balance < amount){
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        this.balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
}
