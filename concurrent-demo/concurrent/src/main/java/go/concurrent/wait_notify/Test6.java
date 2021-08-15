package go.concurrent.wait_notify;

import lombok.extern.slf4j.Slf4j;


/**
 * 1、什么是对象头？
 *  什么是对象？内存级别而言来研究什么是对象
 */
@Slf4j(topic = "enjoy")
public class Test6 {
    static  Object key = new Object();

    public static   void main(String[] args) throws InterruptedException {
        log.debug("main--------");
        new Thread(() -> {
            synchronized (key) {
                try {
                    /**
                     * wait可以带参数
                     * 第二个纳秒参数 是直接把毫秒+1
                     */
                    key.wait(5000,50);
                    System.out.println("5秒钟之后 main--end------");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "boss").start();
        Thread.sleep(100);
    }
}