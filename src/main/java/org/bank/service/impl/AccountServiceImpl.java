package org.bank.service.impl;

import org.bank.model.Account;
import org.bank.model.Transaction;
import org.bank.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private Account account;

    public AccountServiceImpl(Account account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public List<Transaction> getHistory() {
        return account.getHistory();
    }
}
