/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountthreadrunnerwithdeadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankAccountThreadRunner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount account = new BankAccount();
        final double AMOUNT = 100;
        final int REPETITIONS = 1;
        final int THREADS = 100;

        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new DepositRunnable(account, AMOUNT, REPETITIONS));
            executor.execute(new WithdrawRunnable(account, AMOUNT, REPETITIONS));
        }
        executor.shutdown();
    }
    
}
