package org.bank.service;

import org.bank.model.Transaction;

import java.util.List;

public interface AccountService {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    List<Transaction> getHistory();
}
