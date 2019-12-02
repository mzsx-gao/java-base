package com.jdk8.methodReference;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 描述:实例方法引用(引用特定对象的实例方法)
 * 如果函数式接口的实现恰好可以通过调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 * 语法:
 *    inst::instMethod
 */
public class InstanceMethodReference {

    public String put() {
        return "hello";
    }

    public void con(Integer size) {
        System.out.println("size : " + size);
    }

    public String toUpper(String str) {
        System.out.println("current to upper");
        return str.toUpperCase();
    }

    @Test
    public void test(){

        InstanceMethodReference exam = new InstanceMethodReference();

        Supplier<String> s1 = () -> {return new InstanceMethodReference().put();};
        Supplier<String> s = () -> new InstanceMethodReference().put();
        Supplier<String> s2 = new InstanceMethodReference()::put;
        System.out.println(s2.get());

        Consumer<Integer> c1 = (size) -> new InstanceMethodReference().con(size);
        Consumer<Integer> c2 = new InstanceMethodReference()::con;
        Consumer<Integer> c3 = new InstanceMethodReference()::con;
        c2.accept(100);
        c3.accept(100);

        Function<String, String> f3 = str -> exam.toUpper(str);
        Function<String, String> f4 = exam::toUpper;
        System.out.println(f4.apply("javase"));

        //实例方法引用可以直接使用this
        Function<String, String> f5 = this::toUpper;
        System.out.println(f4.apply("javame"));

    }
}