package com.aw.concurrency;

public class BankAccount {

    int balance=100;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        this.balance = balance-amount;
    }
}
