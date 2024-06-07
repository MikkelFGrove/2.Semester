package threads;

public class RunnableTask implements Runnable {
    private int sum;
    private String threadName;
    public RunnableTask(String threadName) {
        sum = 0;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread: " + threadName + " - Current Value: " + sum);
            sum += i;
        }
        System.out.println("Thread: " + threadName + " - Sum: " + sum);
    }
}
