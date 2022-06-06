package go.concurrent.ch1.threadlocal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类说明：ThreadLocal造成的内存泄漏演示
 */
public class ThreadLocalOOM {

    private static final int TASK_LOOP_SIZE = 100;

    final static ThreadPoolExecutor poolExecutor
        = new ThreadPoolExecutor(5, 5,
        1,
        TimeUnit.MINUTES,
        new LinkedBlockingQueue<>());

    static class LocalVariable {
        private byte[] a = new byte[1024 * 1024 * 5]; //5M大小的数组
    }

    ThreadLocal<LocalVariable> localVariable;
    //= new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //5*5=25
        for (int i = 0; i < TASK_LOOP_SIZE; ++i) {
            poolExecutor.execute(() -> {

                //场景一:内存占用基本上为 25M 左右
//                System.out.println("use local varaible");

                //场景二:执行完成后我们可以看见，内存占用基本和场景 1 同
//                new LocalVariable();
//                System.out.println("use local varaible");

                //场景三:执行完成后我们可以看见，内存占用变为了 100 多 M
//                ThreadLocalOOM oom = new ThreadLocalOOM();
//                oom.localVariable = new ThreadLocal<>();
//                oom.localVariable.set(new LocalVariable());
//                System.out.println("use local varaible");

                //场景四:内存占用基本和场景 1 同
                ThreadLocalOOM oom = new ThreadLocalOOM();
                oom.localVariable = new ThreadLocal<>();
                oom.localVariable.set(new LocalVariable());
                System.out.println("use local varaible");
                oom.localVariable.remove();
            });

            Thread.sleep(100);
        }
        System.out.println("pool execute over");
    }

}
