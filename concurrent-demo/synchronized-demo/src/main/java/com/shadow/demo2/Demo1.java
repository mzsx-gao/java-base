package com.shadow.demo2;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 锁对象的改变
 * 锁定某对象o，如果o的属性发生改变，不影响锁的使用
 * 但是如果o变成另外一个对象，则锁定的对象发生改变
 * 应该避免将锁定对象的引用变成另外一个对象
 */
@Slf4j(topic = "enjoy")
public class Demo1 {

    Object o = new Object();

    public void test(){
        synchronized (o) {
            //t1 在这里无线执行
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.debug(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        Demo1 demo = new Demo1();

        new Thread(demo :: test, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(demo :: test, "t2");

        demo.o = new Object();
        //t2能否执行？
        t2.start();
    }

}
