package com.jdk8.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gao on 2018/3/26.
 */
public class StreamDemo {
    static void gen1() {
        String[] arr = {"a", "b", "1", "2"};
        Stream<String> stream = Stream.of(arr);
        stream.forEach(System.out::println);
    }

    static void gen2() {
        List<String> list = Arrays.asList("a", "b", "1", "2");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    static void gen3() {
        Stream<Integer> stream = Stream.generate( () -> 1);
        stream.limit(10).forEach(System.out::println);
    }

    static void gen4() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    static void gen5() throws Exception {
        String str = "abcd";
        IntStream stream = str.chars();

//		stream.forEach(x -> System.out.println(x));
        stream.forEach(System.out::println);

        Files.lines(Paths.get("d:/Person.java")).forEach(System.out::println);
    }
}
