import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private int count;

    public void increment() {
        lock.lock();
        try {
            count++;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                condition.await();
            }
            count--;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Main value = new Main();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 100; i++) {
                value.increment();
            }
        };

        Runnable decrementTask = () -> {
            for (int i = 0; i < 100; i++) {
                try {
                    value.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread incrementThread = new Thread(incrementTask);
        Thread decrementThread = new Thread(decrementTask);

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(value.count);
    }
}
