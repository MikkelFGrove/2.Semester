/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountthreadrunnerwithconditions;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class BankAccount {

    private double balance;
    private Lock balanceChangeLock;
    private Condition newDeposit;
    

    public BankAccount() {
        balance = 0;
        balanceChangeLock = new ReentrantLock();
        newDeposit = balanceChangeLock.newCondition();
    }

    public void deposit(double amount) {
        balanceChangeLock.lock();
        try {
            System.out.print("Depositing " + amount);
            double newBalance = balance + amount;
            System.out.println(", new balance is " + newBalance);
            balance = newBalance;
            newDeposit.signalAll();
        } finally {
            balanceChangeLock.unlock();
        }

    }

    public void withdraw(double amount) {
        balanceChangeLock.lock();
        while (balance < amount) {
            try {
                newDeposit.await();

            } catch (InterruptedException e) {
            }
        }
        System.out.print("Withdrawing " + amount);
        double newBalance = balance - amount;
        System.out.println(", new balance is " + newBalance);
        balance = newBalance;
        balanceChangeLock.unlock();
    }
    public double getBalance() {
        return balance;
    }
}
