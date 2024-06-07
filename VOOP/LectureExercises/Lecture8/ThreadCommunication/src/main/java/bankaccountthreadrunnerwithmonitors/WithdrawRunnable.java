/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountthreadrunnerwithmonitors;


class WithdrawRunnable implements Runnable{

    private static final int DELAY = 1;
    private BankAccount account;
    private double amount;
    private int count;

    /**
     * Constructs a withdraw runnable.
     *
     * @param anAccount the account from which to withdraw money
     * @param anAmount the amount to withdraw in each repetition
     * @param aCount the number of repetitions
     */

    public WithdrawRunnable(BankAccount anAccount, double anAmount, int aCount) {
        account = anAccount;
        amount = anAmount;
        count = aCount;
    }

    @Override
     public void run() {
        try {
            for (int i = 0; i < count; i++) {
                account.withdraw(amount);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException e) {
        }
    }

}
