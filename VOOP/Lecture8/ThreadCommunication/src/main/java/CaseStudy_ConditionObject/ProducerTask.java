package CaseStudy_ConditionObject;

public class ProducerTask implements Runnable {
    private Buffer buffer;

    public ProducerTask(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            int i = 1;
            while (true) {
                System.out.println("Producer writes " + i);
                buffer.write(i++); // Add a value to the buffer
                // Put the thread into sleep
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}