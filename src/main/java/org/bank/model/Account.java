package org.bank.model;

import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.NonPositiveException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new NonPositiveException("Deposit amount must be greater than zero.");
        }
        this.balance += amount;
        this.transactions.add(new Transaction("Deposit", LocalDate.now(), amount, this.balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new NonPositiveException("Withdrawal amount must be greater than zero.");
        }
        if (this.balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
        this.balance -= amount;
        this.transactions.add(new Transaction("Withdraw", LocalDate.now(), amount, this.balance));
    }

    public List<Transaction> getHistory() {
        return this.transactions.stream()
                .map(transaction -> new Transaction(transaction.getOperation(), transaction.getDate(), transaction.getAmount(), transaction.getBalance()))
                .toList();
    }

    public double getBalance() {
        return balance;
    }
}
