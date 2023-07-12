package org.bank.exceptions;

public class InsufficientBalanceException extends IllegalArgumentException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

