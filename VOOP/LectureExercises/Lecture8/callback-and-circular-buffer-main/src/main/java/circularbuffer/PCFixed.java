package circularbuffer;

public class PCFixed {
    public static void main(String args[]) throws InterruptedException {
        CircularBuffer buffer = new CircularBuffer(5);
        new Producer(buffer, 0);
        new Producer(buffer, 1);
        new Producer(buffer, 2);
        new Producer(buffer, 3);
        new Producer(buffer, 4);
        new Producer(buffer, 5);
        new Producer(buffer, 6);
        new Producer(buffer, 7);
        new Producer(buffer, 8);
        new Producer(buffer, 9);

        new Consumer(buffer, 0);
        new Consumer(buffer, 1);
        new Consumer(buffer, 2);

    }
}

