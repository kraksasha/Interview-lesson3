package Example2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    private Counter cr;
    private long counter1 = 0L;

    public CounterThread(Counter cr){
        this.cr = cr;
    }

    @Override
    public void run() {
        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
            try {
                for (int i = 0; i < 1000; i++){
                    cr.setCounter(counter1++);
                }
            } finally {
                lock.unlock();
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted wait");
        }
    }
}
