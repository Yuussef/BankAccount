package org.bank.service;

import org.bank.model.Account;
import org.bank.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AccountServiceImplTest {

    private AccountService accountService;

    @BeforeEach
    public void setup() {
        accountService = new AccountServiceImpl(new Account());
    }

    @Test
    public void depositTest() {
        accountService.deposit(100.0);
        assertEquals(100.0, accountService.getBalance());
    }

    @Test
    public void withdrawTest() {
        accountService.deposit(200.0);
        accountService.withdraw(50.0);
        assertEquals(150.0, accountService.getBalance());
    }

    @Test
    public void getHistoryTest() {
        this.accountService.deposit(100.0);
        this.accountService.withdraw(50.0);
        this.accountService.deposit(200.0);
        assertEquals(3, this.accountService.getHistory().size());
    }
}
