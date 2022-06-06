package my_demo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * 使用线程的方式去执行程序
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                list.add(random.nextInt());
            });
            thread.start();
            thread.join();
        }
        System.out.println("时间：" + (System.currentTimeMillis() - start));
        System.out.println("大小：" + list.size());

    }
}
