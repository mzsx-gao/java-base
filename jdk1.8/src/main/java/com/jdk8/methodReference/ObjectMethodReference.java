package com.jdk8.methodReference;

import org.junit.Test;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;


/**
 * 描述:对象方法引用(引用特定类型的任意对象的实例方法)
 *     满足一下两个条件:
 *     1.抽象方法的第一个参数类型刚好是实例方法的类型
 *     2.抽象方法剩余的参数恰好可以当做实例方法的参数。
 *     如果函数式接口的实现能由上面说的实例方法调用来实现的话，那么就可以使用对象方法引用
 * 语法:
 *    类名::instMethod
 */
public class ObjectMethodReference {

    @Test
    public void test(){

        //示例1
        Consumer<Too> c = new Consumer<Too>() {
            @Override
            public void accept(Too too) {

            }
        };
        Consumer<Too> c1 = (Too too) -> new Too().foo();
        Consumer<Too> c2 = (Too too) -> new Too2().foo();
        Consumer<Too> c3 = Too::foo;

        c1.accept(new Too());
        c2.accept(new Too());
        c3.accept(new Too());

        //示例2
        BiConsumer<Too2, String> c4 = new BiConsumer<Too2, String>() {
            @Override
            public void accept(Too2 too2, String s) {
                too2.fo(s);
            }
        };
        BiConsumer<Too2, String> c5 = (too2, str) -> too2.fo(str);
        BiConsumer<Too2, String> c6 = Too2::fo;

        //示例3
        BiFunction<Prod, String, Integer> bf0 = new BiFunction<Prod, String, Integer>() {
            @Override
            public Integer apply(Prod prod, String s) {
                return prod.fun(s);
            }
        };
        BiFunction<Prod, String, Integer> bf1 = (p, s) -> new Prod().fun(s);
        BiFunction<Prod, String, Integer> bf2 = (p, s) -> new Too().fun(s);
        BiFunction<Prod, String, Integer> bf3 = Prod::fun;

        //示例4
        Execute ex1 = (p,name,size) -> new Prod().run(name, size);
        Execute ex2 = Prod::run;
    }
}

interface Execute {
    void run(Prod p, String name, String size);
}

class Prod {

    public void run(String name, String size) {

    }

    public Integer fun(String s) {
        return 1;
    }

}
class Too {
    public Integer fun(String s) {
        return 1;
    }

    public void foo() {
        System.out.println("invoke");
    }
}

class Too2 {

    public void foo() {
        System.out.println("invoke");
    }

    public void fo(String str) {

    }
}