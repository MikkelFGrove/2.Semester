/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountthreadrunnerwithmonitors;

class BankAccount {

    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public synchronized void deposit(double amount) {

        System.out.print("Depositing " + amount);
        double newBalance = balance + amount;
        System.out.println(", new balance is " + newBalance);
        balance = newBalance;
        notifyAll();
    }

    public synchronized void withdraw(double amount) {

        while (balance < amount) {
            try {
                wait();

            } catch (InterruptedException e) {
            }
        }
        System.out.print("Withdrawing " + amount);
        double newBalance = balance - amount;
        System.out.println(", new balance is " + newBalance);
        balance = newBalance;
    }

    public double getBalance() {
        return balance;
    }
}
