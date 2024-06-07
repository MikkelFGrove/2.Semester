package threads;

public class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void increment() {
        this.counter = this.counter + 2;
    }

    public void decrement() {
        this.counter--;
    }
}
