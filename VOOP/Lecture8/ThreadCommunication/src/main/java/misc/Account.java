package misc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        lock.lock(); // Acquire the lock
        try {
            int newBalance = balance + amount;
            // Simulate delay to magnify the concurrency issue
            Thread.sleep(1000);
            balance = newBalance;
            System.out.println("Deposit successful. New balance: " + balance);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(500);
        Account account2 = new Account(300);

        // Simulate multiple threads depositing funds into different accounts simultaneously
        Thread threadA = new Thread(() -> account1.deposit(100));
        Thread threadB = new Thread(() -> account2.deposit(50));

        threadA.start();
        threadB.start();
    }
}

