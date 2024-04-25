package ThreadsUsingThread;

public class PrintChar extends Thread {

    private char charToPrint; // The character to print
    private int times; // The times to repeat

    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                System.out.print(charToPrint);
                Thread.sleep(1);
            }
        }
        catch (InterruptedException e) {

        }
    }
}

