package tutorialspoint_3;

public class Consumer implements Runnable {

    private Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int i=0;
        while (i<=10) {
            q.get();
            i++;
        }
    }
}
