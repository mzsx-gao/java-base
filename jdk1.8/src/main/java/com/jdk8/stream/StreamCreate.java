package com.jdk8.stream;

import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream的创建
 *
 Stream特性:
 1：不是数据结构，没有内部存储
 2：不支持索引访问
 3：延迟计算
 4：支持并行
 5：很容易生成数组或集合（List，Set）
 6：支持过滤，查找，转换，汇总，聚合等操作

 */
public class StreamCreate {

    //1.通过数组来创建
    @Test
    public void gen1() {
        String[] arr = {"a", "b", "1", "2"};
        Stream<String> stream = Stream.of(arr);
//        stream.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });
//        stream.forEach((s)->System.out.println(s));
        stream.forEach(System.out::println);
    }

    //2.通过集合来创建
    @Test
    public void gen2() {
        List<String> list = Arrays.asList("a", "b", "1", "2");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    //3.通过Stream.generate()方法来创建
    //Stream.generate(Supplier<T> s)方法返回无限顺序无序流，其中每个元素Supplier提供 。 这适合于产生恒定流，随机元素流等
    @Test
    public void gen3() {
        Stream<Integer> stream = Stream.generate( () -> 1);
        stream.limit(10).forEach(System.out::println);
    }

    /*
    4.通过Stream.iterate()方法来创建
    Stream.iterate(T seed,UnaryOperator<T> f)返回有序无限连续Stream
    参数:
    seed - 初始元素
    f - 要应用于前一个元素以生成新元素的函数
     */
    @Test
    public void gen4() {
//        Stream<Integer> stream1 = Stream.iterate(new Integer(1), new UnaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer x) {
//                return x+1;
//            }
//        });
//        Stream<Integer> stream2 = Stream.iterate(new Integer(1), x -> x+1);
        Stream<Integer> stream3 = Stream.iterate(1, x -> x + 1);
        stream3.limit(10).forEach(System.out::println);
    }


    //5.其它方式常见Stream
    @Test
    public void gen5() throws Exception {
        String str = "abcd";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }
}
