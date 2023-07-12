package org.bank.model;

import org.bank.exceptions.InsufficientBalanceException;
import org.bank.exceptions.NonPositiveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account account;
    private Transaction transaction1;
    private Transaction transaction2;
    private Transaction transaction3;
    @BeforeEach
    public void setup() {
        account = new Account();
        transaction1 = new Transaction("Deposit", LocalDate.of(2023, 7, 1), 100.0, 100.0);
        transaction2 = new Transaction("Withdrawal", LocalDate.of(2023, 7, 2), 50.0, 50.0);
        transaction3 = new Transaction("Deposit", LocalDate.of(2023, 7, 3), 200.0, 250.0);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        account.setTransactions(transactions);
    }
    @Test
    public void depositTest_shouldReturnBalance_whenAmountExist() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }
    @Test
    public void DepositTest_shouldReturnNonPositiveException() {
        assertThrows(NonPositiveException.class, () -> account.deposit(-50));
        assertThrows(NonPositiveException.class, () -> account.deposit(0));
    }

    @Test
    public void withdrawTest_shouldReturnBalance() {
        account.deposit(100);
        account.withdraw(50);
        assertEquals(50, account.getBalance());
    }
    @Test
    public void notPositivewithdrawTest_shouldThrowNonPositiveException() {
        assertThrows(NonPositiveException.class, () -> account.withdraw(-50));
        assertThrows(NonPositiveException.class, () -> account.withdraw(0));
    }
    @Test
    public void InsufficientBalancewithdrawTest_shouldThrowInsufficientBalanceException() {
        assertThrows(InsufficientBalanceException.class, () -> account.withdraw(50));
    }
    @Test
    public void testGetHistory_whenListOfThreeElement() {
        List<Transaction> expectedHistory = List.of(
                new Transaction("Deposit", LocalDate.of(2023, 7, 1), 100.0, 100.0),
                new Transaction("Withdrawal", LocalDate.of(2023, 7, 2), 50.0, 50.0),
                new Transaction("Deposit", LocalDate.of(2023, 7, 3), 200.0, 250.0)
        );
        List<Transaction> actualHistory = account.getHistory();
        Assertions.assertEquals(expectedHistory.size(), actualHistory.size());
        Assertions.assertEquals(expectedHistory.get(0).getOperation(), actualHistory.get(0).getOperation());
    }
    @Test
    public void testGetHistory_EmptyTransactions() {
        List<Transaction> expectedHistory = new ArrayList<>();
        account.setTransactions(expectedHistory);
        List<Transaction> actualHistory = account.getHistory();
        Assertions.assertEquals(expectedHistory, actualHistory);
    }
}