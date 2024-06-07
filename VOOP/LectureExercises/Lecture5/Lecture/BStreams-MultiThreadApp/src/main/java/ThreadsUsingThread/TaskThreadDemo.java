package ThreadsUsingThread;

public class TaskThreadDemo {
    public static void main(String[] args) {

        // Create threads
        Thread thread1 = new PrintChar('a', 100);
        Thread thread2 = new PrintChar('b', 100);
        Thread thread3 = new PrintNum(100);


        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

    }
}


