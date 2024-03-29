package go.concurrent.ch4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 类说明：使用Lock的范例
 */
public class LockCase {
    private Lock lock = new ReentrantLock();
    private int age = 100000;//初始100000

    private static class TestThread extends Thread {

        private LockCase lockCase;

        public TestThread(LockCase lockCase, String name) {
            super(name);
            this.lockCase = lockCase;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {//递增100000
                lockCase.test();
            }
            System.out.println(Thread.currentThread().getName()
                + " age =  " + lockCase.getAge());
        }
    }

    public void test() {
        lock.lock();
        try {
            age++;
        } finally {
            lock.unlock();
        }
    }

    public void test2() {
        lock.lock();
        try {
            age--;
        } finally {
            lock.unlock();
        }
    }

    public int getAge() {
        return age;
    }


    public static void main(String[] args) throws InterruptedException {
        LockCase lockCase = new LockCase();
        Thread endThread = new TestThread(lockCase, "endThread");
        endThread.start();
        for (int i = 0; i < 100000; i++) {//递减100000
            lockCase.test2();
        }
        System.out.println(Thread.currentThread().getName()
            + " age =  " + lockCase.getAge());
    }
}