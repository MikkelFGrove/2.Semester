package multithreading;

public class WithdrawTask implements Runnable{
    String account;
    double amount;
    Logger logger;

    public WithdrawTask(String account, double amount, Logger logger){
        this.account = account;
        this.amount = amount;
        this.logger = logger;
    }

    @Override
    public void run() {
        logger.logWithdraw(account,amount);
    }
}
