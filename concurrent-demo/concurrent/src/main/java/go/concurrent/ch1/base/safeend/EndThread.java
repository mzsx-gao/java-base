package go.concurrent.ch1.base.safeend;

/**
 * 类说明：如何安全中断线程
 */
public class EndThread {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " interrrupt flag =" + isInterrupted());

            // while(!Thread.interrupted()) -> Thread.interrupted()会同时将中断标识位改写为 false
            while (!isInterrupted()) {
                System.out.println(threadName + " is running");
                System.out.println(threadName + " inner interrrupt flag =" + isInterrupted());
            }
            System.out.println(threadName + " interrrupt flag =" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();//中断线程，其实设置线程的标识位true
    }
}