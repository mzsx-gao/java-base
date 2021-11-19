package go.concurrent.ch1.syn;

/**
 * 类说明：错误的加锁和原因分析
 */
public class TestIntegerSyn {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker(1);
        //Thread.sleep(50);
        for (int i = 0; i < 5; i++) {
            new Thread(worker).start();
        }
    }

    private static class Worker implements Runnable {

        private Integer i;
        private Object o = new Object();

        public Worker(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            //synchronized (i) {
            synchronized (o) {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "--@" + System.identityHashCode(i));
                i++;//i++ 本质上是返回了一个新的 Integer 对象,也就是每个线程实际加锁的是不同的 Integer 对象
                System.out.println(thread.getName() + "-------" + i + "-@" + System.identityHashCode(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + "-------" + i + "--@" + System.identityHashCode(i));
            }
        }
    }
}