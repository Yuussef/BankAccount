package org.bank.model;

import java.time.LocalDate;

public class Transaction {
    private final String operation;
    private final LocalDate date;
    private final double amount;
    private final double balance;

        public Transaction(String operation,LocalDate date, double amount, double balance) {
            this.operation=operation;
            this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
    public String getOperation() {
        return operation;
    }
    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}
