package org.bank.model;

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
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }


}