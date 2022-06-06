package gao.javabase.algorithm.flowControl;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 名称: SlidingTimeWindow
 * 描述: 滑动时间窗口限流实现
 * 假设某个服务最多只能每秒钟处理100个请求，我们可以设置一个1秒钟的滑动时间窗口，
 * 窗口中有10个格子，每个格子100毫秒，每100毫秒移动一次，每次移动都需要记录当前服务请求的次数
 *
 * @author gaoshudian
 * @date 4/25/22 1:16 PM
 */
@Slf4j
public class SlidingTimeWindow {

    //服务访问次数，可以放在Redis中，实现分布式系统的访问计数
    Long counter = 0L;
    //使用LinkedList来记录滑动窗口的10个格子。
    LinkedList<Long> slots = new LinkedList<>();

    private static Boolean flowLimit = false; //限流标记

    private static AtomicInteger reqCount = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        SlidingTimeWindow timeWindow = new SlidingTimeWindow();

        new Thread(() -> {
            try {
                //限流逻辑
                timeWindow.doCheck();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        while (true) {
            if (reqCount.get() == 500) {//总共发500个请求停止
                break;
            }
            if (!flowLimit) {
                Thread.sleep(new Random().nextInt(15)); //业务逻辑
                timeWindow.counter++;                   //请求数+1

                reqCount.addAndGet(1);
//                log.debug("请求: " + reqCount.get() + "通过");
            } else {
                log.debug("请求：" + reqCount.addAndGet(1) + "####限流了");
                Thread.sleep(new Random().nextInt(100));
            }

        }
    }

    /**
     * 限流逻辑，如果满足限流条件则将flowLimit置为true；
     * 限流打开后，当再往后推一个窗格后如果发现最近10个窗格请求数小于100，则重新关闭限流
     */
    private void doCheck() throws InterruptedException {
        while (true) {
            if (reqCount.get() == 500) {//总共发500个请求停止
                break;
            }
            Thread.sleep(100);//每100ms一个窗格
            slots.addLast(counter);
            if (slots.size() > 10) {//保证只有10个窗格，其实就相当于是向后移动了一个窗格
                slots.removeFirst();
                log.debug("向后挪动一个窗格: 新加入的窗格：" + counter + "   第一个窗格：" + slots.peekFirst());
            }else{
                log.debug("加一个窗格: 当前请求数：" + counter + " 窗格数量:" + slots.size());
            }
            //比较最后一个和第一个，两者相差100以上就限流
            if ((slots.peekLast() - slots.peekFirst()) > 100) {
//                System.err.println("限流了。。");
                flowLimit = true;
            } else {
                if (flowLimit) {
//                    System.err.println("重新放开。。");
                    flowLimit = false;
                }
            }
        }
    }
}