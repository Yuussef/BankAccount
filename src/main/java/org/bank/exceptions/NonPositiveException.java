package org.bank.exceptions;

public class NonPositiveException extends IllegalArgumentException {
    public NonPositiveException(String msg) {
        super(msg);
    }
}