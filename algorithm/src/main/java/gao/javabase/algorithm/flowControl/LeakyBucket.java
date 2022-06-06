package gao.javabase.algorithm.flowControl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 名称: LeakyBucket
 * 描述: 漏桶限流算法
 *
 * Sentinel的排队等待算法其实不是这么设计的，sentinel中是根据水漏出的速度，计算出两个请求之间应有的时间间隔，如果时间间隔小于这个值，则
 * Thread.sleep到时间间隔后再放行（注意其中要配置一个最大的超时时间，如果等待时间超过这个值，则限流）
 *
 * @author gaoshudian
 * @date 4/25/22 11:01 PM
 */
public class LeakyBucket {

    public static volatile long timeStamp = System.currentTimeMillis();  // 当前时间
    public static volatile long capacity = 100l; // 桶的容量（最多缓冲100个请求）
    public static volatile long rate = 10l; // 水漏出的速度(每毫秒系统能处理的请求数)
    public static volatile long water = 0l; // 当前水量(当前累积请求数)

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        System.out.println("开始时间:" + LocalDateTime.now());

        //漏水
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long now = System.currentTimeMillis();
                //算出时间间隔内漏多少水
                long ss = new BigDecimal(now).subtract(new BigDecimal(timeStamp))
                    .divide(new BigDecimal(1000)).multiply(new BigDecimal(rate)).longValue();
                water = Math.max(0, water - ss);
                timeStamp = now;
            }
        }).start();

        //加水
        while (true) {
            //来一次请求，加水
            int currCount = count.addAndGet(1);
            if(currCount == 500){
                break;
            }
            if ((water + 1) < capacity) {
                // 尝试加水,并且水还未满
                water += 1;
                System.out.println("通过" + currCount);
                Thread.sleep(new Random().nextInt(130));
            } else {
                // 水满，拒绝加水
                System.out.println("限流。。。" + currCount + LocalDateTime.now());
                break;
            }
        }
    }
}