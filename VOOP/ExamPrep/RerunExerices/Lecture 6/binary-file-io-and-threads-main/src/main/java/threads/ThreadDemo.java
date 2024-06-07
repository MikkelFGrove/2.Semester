package threads;

public class ThreadDemo {

    public static void main(String[] args)
    {
        /*RunnableTask A = new RunnableTask("A");
        RunnableTask B = new RunnableTask("B");
        RunnableTask C = new RunnableTask("C");

        Thread t1 = new Thread(A);
        Thread t2 = new Thread(B);
        Thread t3 = new Thread(C);
        t1.start();
        t2.start();
        t3.start();
        */
        Counter counter = new Counter();
        System.out.println("The value of counter before running threads is: " + counter.getCounter());

        Task1 t1 = new Task1(counter);
        Task2 t2 = new Task2(counter);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception when sleeping thread");
        }

        System.out.println("The value of counter after running threads is: " + counter.getCounter());
    }
}
