package com.gao.jvm;

/**
 *   名称: DynamicDispatch.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/6/6 10:56
 *   @version [版本号, V1.0]
 *   @since 2018/6/6 10:56
 *   @author gaoshudian
 */
public class DynamicDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }
    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}