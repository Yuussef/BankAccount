package org.bank.model;

public class Account {
    private double balance;


    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
