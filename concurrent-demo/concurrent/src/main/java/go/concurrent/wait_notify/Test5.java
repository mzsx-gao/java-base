package go.concurrent.wait_notify;

import lombok.extern.slf4j.Slf4j;

/**
 * 1、什么是对象头？
 *  什么是对象？内存级别而言来研究什么是对象
 */
@Slf4j(topic = "enjoy")
public class Test5 {
    static boolean isPrettyGril = false;
    static boolean isMoney = false;
    static  Object key = new Object();

    //wait方法外层改成while循环
    public static   void main(String[] args) throws InterruptedException {
        //jack
        new Thread(() -> {
            synchronized (key) {
                log.debug("有没有女人[{}]", isPrettyGril);
                while (!isPrettyGril) {
                    log.debug("没有女人！等女人");
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("老板把我叫醒了 有没有女人？[{}]", isPrettyGril);
                if (isPrettyGril) {
                    log.debug("------男女搭配干活不累；啪啪啪写完了代码");
                }else{
                    log.debug("------下班回家----");
                }
            }
        }, "jack").start();

        new Thread(() -> {
            synchronized (key) {
                log.debug("有没有钱[{}]", isMoney);
                while (!isMoney) {
                    log.debug("没有钱则等钱 wait");
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("老板把我叫醒了 有没有钱？[{}]", isMoney);
                if (isMoney) {
                    log.debug("------卧槽---有钱了干活了");
                }else{
                    log.debug("------没钱回家----");
                }
            }
        }, "rose").start();

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (key) {
                isMoney = true;
                log.debug("给钱了");
                //随机叫醒一个
                key.notifyAll();
            }
        }, "boss").start();
    }
}