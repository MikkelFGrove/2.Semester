package tutorialspoint_3;

public class Producer implements Runnable {
       private Q q;
        public Producer(Q q) {
            this.q = q;
            new Thread(this, "Producer").start();
        }

        public void run() {
            int i = 0;
            while(i<=10) {
                q.put(i++);
            }
        }
    }


