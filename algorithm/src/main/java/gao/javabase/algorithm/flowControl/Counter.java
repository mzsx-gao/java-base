package gao.javabase.algorithm.flowControl;

/**
 * 名称: Counter
 * 描述: 最简单的计数器限流算法
 *
 * @author gaoshudian
 * @date 4/25/22 11:17 AM
 */
public class Counter {

    public long timeStamp = System.currentTimeMillis();  // 当前时间
    public final long interval = 1000 * 5; // 时间窗口ms
    public int reqCount = 0;  // 初始化计数器
    public final int limit = 100; // 时间窗口内最大请求数

    public boolean limit() {
        long now = System.currentTimeMillis();
        if (now < timeStamp + interval) {
            // 在时间窗口内
            reqCount++;
            // 判断当前时间窗口内是否超过最大请求控制数
            return reqCount <= limit;
        } else {
            timeStamp = now;
            // 超时后重置
            reqCount = 1;
            return true;
        }
    }

    public static void main(String[] args){
        Counter counter = new Counter();
        boolean pass = true;
        while (pass) {
            if (!counter.limit()) {
                pass = false;
            }else{
                System.out.println("通过请求数:" + counter.reqCount);
            }
        }
        System.out.println("请求达到上限，结束");
    }
}