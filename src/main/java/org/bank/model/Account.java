    package org.bank.model;

    import org.bank.exceptions.InsufficientBalanceException;
    import org.bank.exceptions.NonPositiveException;
    import java.util.List;

    public class Account {
        private double balance;
        private List<Transaction> transactions;

        public Account() {
            this.balance = 0;
        }
        public void setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
        }
        public void deposit(double amount) {
            if(amount <= 0){
                throw new NonPositiveException("Deposit amount must be greater than zero.");
            }
            this.balance += amount;
        }
        public void withdraw(double amount) {
            if(amount <= 0){
                throw new NonPositiveException("Withdrawal amount must be greater than zero.");
            }
            if(this.balance < amount){
                throw new InsufficientBalanceException("Insufficient balance.");
            }
            this.balance -= amount;
        }
        public List<Transaction> getHistory() {
            return this.transactions.stream()
                    .map(transaction -> new Transaction(transaction.getOperation(), transaction.getDate(), transaction.getAmount(), transaction.getBalance()))
                    .toList();
        }

        public double getBalance() {
            return balance;
        }
    }
