package go.concurrent.ch1.base;

import java.util.concurrent.ExecutionException;

/**
 * 守护线程的使用
 */
public class DaemonThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " I am extends Thread.");
                }
            } finally {
                //守护线程中finally不一定起作用
                System.out.println(" .............finally");
            }
        }
    }

    static {
        UseThread useThread = new UseThread();
        useThread.setDaemon(true);
        useThread.start();
    }

    public static void main(String[] args) throws InterruptedException {
//		UseThread useThread = new UseThread();
//		useThread.setDaemon(true);
//		useThread.start();
        Thread.sleep(2000);
//		useThread.interrupt();
    }
}
