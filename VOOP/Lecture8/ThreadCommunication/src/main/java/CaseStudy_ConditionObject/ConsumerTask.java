package CaseStudy_ConditionObject;

public class ConsumerTask implements Runnable {

    private Buffer buffer;

    public ConsumerTask(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("\t\t\tConsumer reads " + buffer.read());
                // Put the thread into sleep
                Thread.sleep(100);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

