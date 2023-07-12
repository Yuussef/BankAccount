package org.bank.model;

import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.NonPositiveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {

    @Test
    public void depositTest() {
        Account account = new Account();
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }
    @Test
    public void notPositiveDepositTest() {
        Account account = new Account();
        assertThrows(NonPositiveException.class, () -> account.deposit(-50));
        assertThrows(NonPositiveException.class, () -> account.deposit(0));
    }

    @Test
    public void withdrawTest() {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }
    @Test
    public void notPositivewithdrawTest() {
        Account account = new Account();
        assertThrows(NonPositiveException.class, () -> account.withdraw(-50));
        assertThrows(NonPositiveException.class, () -> account.withdraw(0));
    }
    @Test
    public void InsufficientBalancewithdrawTest() {
        Account account = new Account();
        assertThrows(InsufficientBalanceException.class, () -> account.withdraw(50));
    }
}