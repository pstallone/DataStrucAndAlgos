package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    private int[] buffer;
    private int count = 0;
    private int pcnt;
    private int tcnt;
    private ReentrantLock lock;
    private Condition fullcond;
    private Condition emptyCond;

    public BoundedBuffer(int size) {
        buffer = new int[size];
        pcnt = 0;
        tcnt = 0;
        lock = new ReentrantLock();
        fullcond = lock.newCondition();
        emptyCond = lock.newCondition();
    }

    // ints will be stored in a circular buffer (array) since the put and take index will wrap
    public void put(int a) throws InterruptedException{
        try {
            lock.lock();
            while (count == buffer.length) {
                fullcond.await();
            }
            buffer[pcnt++] = a;
            // wrap back to first elem
            if (pcnt == buffer.length)
                pcnt = 0;
            count++;
            fullcond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int take() throws InterruptedException {
        try {
            lock.lock();
            while (count == 0) {
                emptyCond.await();
            }
            int x = buffer[tcnt++];
            // wrap to first elem
            if (tcnt == 0)
                tcnt = 0;
            count--;
            emptyCond.signalAll();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
