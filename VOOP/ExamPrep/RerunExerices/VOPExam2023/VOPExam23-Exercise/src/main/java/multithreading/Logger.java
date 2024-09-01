package multithreading;


import java.io.*;

public class Logger {

    private static Logger logger;
    private String logFile;
    private PrintWriter writer;

    private Logger(){
        logFile = "log.txt";
    }

    public static Logger getInstance(){
        if(logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public synchronized void logWithdraw  (String account, double amount) {

        try {
            writer = new PrintWriter(new FileWriter(logFile, true));
            writer.print("WITHDRAW " + account + ": " + amount + "$");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } finally {
            writer.close();
        }


    }

    public synchronized void logDeposit (String account, double amount) {
        try {
            writer = new PrintWriter(new FileWriter(logFile, true));
            writer.print("DEPOSIT " + account + ": " + amount + "$");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } finally {
            writer.close();
        }

    }

    public synchronized void logTransfer (String fromAccount, String toAccount, double amount) {
        try {
            writer = new PrintWriter(new FileWriter(logFile, true));
            writer.print("TRANSFER " + fromAccount + "->" + toAccount + ": " + amount + "$");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        } finally {
            writer.close();
        }
    }



}
