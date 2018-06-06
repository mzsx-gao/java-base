package com.gao.jvm;

/**
 *   名称: StaticDispatch.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/6/6 10:51
 *   @version [版本号, V1.0]
 *   @since 2018/6/6 10:51
 *   @author gaoshudian
 */
public class StaticDispatch {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}