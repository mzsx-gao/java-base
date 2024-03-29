package com.shadow.demo9;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile 关键字，使一个变量在多个线程间可见
 * mian,t1线程都用到一个变量，java默认是T1线程中保留一份副本，这样如果main线程修改了该变量，t1线程未必知道
 *
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 *
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个副本，
 * 并不会每次都去读取堆内存，这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行
 * 但是这可能是个错误
 * 关于这个例子  在后面会专门花时间再讲
 */
@Slf4j(topic = "enjoy")
public class Demo {

    boolean  running = true;
    List<String> list = new ArrayList<>();

    /**
     * t1线程
     */
    public void test() {
        log.debug("test start...");
        boolean flag = running;
        while (running) {
            //加上这行打印语句就可以跳出while循环
//            System.out.println(".......");
        }
        log.debug("test end...");
    }

    public static void main(String[] args) throws Exception {
        Demo demo = new Demo();
        new Thread(demo::test, "t1").start();
        Thread.sleep(100);
        demo.running = false;
    }
}