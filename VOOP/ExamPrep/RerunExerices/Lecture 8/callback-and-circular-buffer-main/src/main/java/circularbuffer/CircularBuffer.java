package circularbuffer;

import java.util.Arrays;

public class CircularBuffer {
    private Integer[] buffer;
    private int size;
    private int putIndex = 0;
    private int getIndex = 0;

    public CircularBuffer(int size) {
        buffer = new Integer[size];
        this.size = size;
    }

    synchronized void get() {
        if (buffer[getIndex] != null){

            System.out.println(Thread.currentThread().getName()+"\tGot: " + getIndex + ": " + buffer[getIndex]);
            buffer[getIndex] = null;
            getIndex = (getIndex + 1) % size;
            notifyAll();
        }

        else {
            System.out.println("*** Buffer Empty ***");
            try {
                wait(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void put(int n) {
        if(buffer[putIndex] == null){
            buffer[putIndex] = n;
            System.out.println(Thread.currentThread().getName()+" Put: " + putIndex+ ": " + n);
            putIndex = (putIndex + 1) % size;
            notifyAll();
        }

        else {
            System.out.println("*** Buffer full ***");
            try {
                wait(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public String toString() {
        return "Buff: " + Arrays.toString(buffer);
    }
}


