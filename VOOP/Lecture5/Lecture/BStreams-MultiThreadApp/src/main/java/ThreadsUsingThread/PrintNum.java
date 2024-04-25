package ThreadsUsingThread;

public class PrintNum extends Thread{
    private int lastNum;
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }
    }
}

