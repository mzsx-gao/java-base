package com.jdk8.lambda;

import org.junit.Test;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *   名称: LambdaDemo.java
 *   描述: lambda表达式使用示例
 *   类型: JAVA
 *   最近修改时间:2018/3/14 14:29
 *   @version [版本号, V1.0]
 *   @since 2018/3/14 14:29
 *   @author gaoshudian
 */
public class LambdaDemo {

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("run...");
            }
        };
        r1.run();

        Runnable r2 = () -> {System.out.println("lambda run...");};
        r2.run();;

        Runnable r3 = () -> System.out.println("lambda run...");
        r3.run();
    }

    @Test
    public void test2() throws Exception{
        Callable<String> c1=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call";
            }
        };
        Callable<String> c2 = () -> {return "lambda call...";};
        Callable<String> c3 = () -> "hello";

        System.out.println(c1.call());
        System.out.println(c2.call());
        System.out.println(c3.call());

    }

    @Test
    public void test3(){
        UserMapper u1 = new UserMapper() {
            @Override
            public void insert(User user) {
                System.out.println("insert user: " + user);
            }
        };
        UserMapper u2=(user) -> {System.out.println("insert user: " + user);};
        UserMapper u3=(User user) -> System.out.println("insert user: " + user);

        u1.insert(new User());
        u2.insert(new User());
        u3.insert(new User());
    }

    @Test
    public void test4(){
        OrderMapper o1 = new OrderMapper() {
            public int insert(Order order) {
                System.out.println("insert order: " + order);
                return 1;
            }
        };
        OrderMapper o2 = (order) -> {return 1;};
        OrderMapper o3 = (Order order) -> {return 1;};
        OrderMapper o4 = (order) -> 1;
        OrderMapper o5 = (Order order) -> 1;

        System.out.println(o1.insert(new Order()));
        System.out.println(o2.insert(new Order()));
        System.out.println(o3.insert(new Order()));
        System.out.println(o4.insert(new Order()));
        System.out.println(o5.insert(new Order()));
    }

    @Test
    public void test5(){

        Function<Integer,String> f1= new Function<Integer, String>() {
            @Override
            public String apply(Integer a) {
                int sum = 0;
                for(int i=1;i<=a;i++) {
                    sum += i;
                }
                return sum+"";
            }
        };

        Function<Integer,String> f2 = a -> {
            int sum = 0;
            for(int i=1;i<=a;i++) {
                sum += i;
            }
            return sum+"";
        };
        System.out.println(f1.apply(10));
        System.out.println(f2.apply(10));
    }

    @Test
    public void test6(){

        /**
         * r1和r2的写法可以，r3和r4的写法不可以
         * 因为Runnable的run方法没有返回值,r3和r4的写法都相当于方法体有返回值,
         * 而r1和r2的写法，虽然调用的方法有返回值，但是整个方法体并没有返回值
         * */
        Runnable r1 = () -> {
            get();
        };
        Runnable r2 = () -> {
            exec();
        };
//        Runnable r3 = () -> 100;
//        Runnable r4 = () -> "";



        Foo f1 = () -> get();
//		Foo f2 = () -> find();
//		Foo f3 = () -> exec();
        Foo f4 = () -> 100;
        Foo f5 = () -> true ? 1 : -1;

        BiFunction<String, String, Integer> bf =(a,b) -> a.length()+b.length();
        System.out.println(bf.apply("java", "se"));

        BiFunction<String, String, Integer> bf1 = (a, b) -> {
            //doing
            return 1;
        };
        bf1.apply("java","c");

        Function<String, Integer> f6 = a -> a.length();
        System.out.println(f6.apply("javaee"));
    }

    static int get() {
        return 1;
    }

    static String find() {
        return "";
    }

    static void exec() {
        find();
    }

    public static void main(String[] args) {

    }

    interface UserMapper {
        void insert(User user);
    }

    interface OrderMapper {
        int insert(Order order);
    }

    interface Foo {
        int get();
    }

    class User {

    }

    class Order {

    }

}