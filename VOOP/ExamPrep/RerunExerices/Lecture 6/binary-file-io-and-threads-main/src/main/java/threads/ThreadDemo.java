package threads;

public class ThreadDemo {

    public static void main(String[] args)
    {
        RunnableTask A = new RunnableTask("A");
        RunnableTask B = new RunnableTask("B");
        RunnableTask C = new RunnableTask("C");

        Thread t1 = new Thread(A);
        Thread t2 = new Thread(B);
        Thread t3 = new Thread(C);
        t1.start();
        t2.start();
        t3.start();
    }
}
