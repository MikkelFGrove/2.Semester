package CaseStudy_ConditionObject;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private static final int CAPACITY = 1; // buffer size
    private LinkedList<Integer> queue = new LinkedList<>();

    // Create a new lock
    private Lock lock = new ReentrantLock();

    // Create two conditions
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public void write(int value) {
        lock.lock(); // Acquire the lock
        try {
            while (queue.size() == CAPACITY) {
                //System.out.println("Wait for notFull condition");
                notFull.await();
            }

            queue.add(value);
            notEmpty.signal(); // Signal notEmpty condition
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public int read() {
        int value = 0;
        lock.lock(); // Acquire the lock
        try {
            while (queue.isEmpty()) {
                //System.out.println("\t\t\tWait for notEmpty condition");
                notEmpty.await();
            }

            value = queue.remove();
            notFull.signal(); // Signal notFull condition
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock(); // Release the lock
            return value;
        }
    }
}

