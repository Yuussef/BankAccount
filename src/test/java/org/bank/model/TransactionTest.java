package org.bank.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {
    private Transaction transaction;

    @BeforeEach
    public void setup() {
        transaction = new Transaction("Ref0001", LocalDate.now(), 100, 200);
    }

    @Test
    public void createOperationRefTest() {
        assertEquals("Ref0001", transaction.getOperation());
    }

    @Test
    public void createDateTest() {
        assertNotNull(transaction.getDate());
    }

    @Test
    public void createAmountTest() {
        assertEquals(100, transaction.getAmount());
    }

    @Test
    public void createBalanceTest() {
        assertEquals(200, transaction.getBalance());
    }
}
