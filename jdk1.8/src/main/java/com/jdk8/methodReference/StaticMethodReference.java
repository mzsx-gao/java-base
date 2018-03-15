package com.jdk8.methodReference;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *   名称: StaticMethodReference.java
 *   描述:静态方法引用
 *       如果函数式接口的实现恰好是通过调用一个静态方法来实现，那么就可以使用静态方法引用
 *       语法
 *          类名::staticMethod
 *
 *   类型: JAVA
 *   最近修改时间:2018/3/15 10:49
 *   @version [版本号, V1.0]
 *   @since 2018/3/15 10:49
 *   @author gaoshudian
 */
public class StaticMethodReference {

    public static String put() {
        System.out.println("put method invoke");
        return "hello";
    }

    public static void con(Integer size) {
        System.out.println("size: " + size);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static Integer len(String s1, String s2) {
        return s1.length() + s2.length();
    }

    //无输入，有输出
    @Test
    public void test1(){
        Supplier<String> s0 = new Supplier<String>() {
            @Override
            public String get() {
                return StaticMethodReference.put();
            }
        };
        Supplier<String> s = () -> StaticMethodReference.put();
        Supplier<String> s1 = () -> Fun.ret();

        Supplier<String> s2 = StaticMethodReference :: put;
        Supplier<String> s3 = Fun :: ret;

        System.out.println(s0.get());
        System.out.println(s.get());
        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
    }

    //有输入，无输出
    @Test
    public void test2(){
        Consumer<Integer> c1 = (size) -> StaticMethodReference.con(size);
        Consumer<Integer> c2 = StaticMethodReference::con;
        c1.accept(100);
        c2.accept(100);
    }

    //有输入，有输出
    @Test
    public void test3(){
        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = str -> StaticMethodReference.toUpperCase(str);
        Function<String, String> f3 = StaticMethodReference::toUpperCase;
        Function<String, String> f4 = Fun::toUpperCase;
        System.out.println(f3.apply("lambda"));
        System.out.println(f4.apply("lambda"));

        BiFunction<String, String, Integer> bf1 = (ss1, ss2) -> ss1.length() + ss2.length();
        BiFunction<String, String, Integer> bf2 = (ss1, ss2) -> StaticMethodReference.len(ss1, ss2);
        BiFunction<String, String, Integer> bf3 = StaticMethodReference::len;
        System.out.println(bf3.apply("java", "se"));
    }
}
class Fun {
    public static String ret() {
        System.out.println("put method invoke");
        return "hello";
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}