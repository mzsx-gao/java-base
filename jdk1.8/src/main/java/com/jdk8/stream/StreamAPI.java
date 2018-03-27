package com.jdk8.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 *   名称: StreamAPI.java
 *   描述: Stream常见API

 中间操作:
     过滤 filter
     去重 distinct
     排序 sorted
     截取 limit、skip
     转换 map/flatMap
     其他 peek

 终止操作:
     循环 forEach
     计算 min、max、count、 average
     匹配 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny
     汇聚 reduce
     收集器 toArray collect

 *   类型: JAVA
 *   最近修改时间:2018/3/27 14:58
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 14:58
 *   @author gaoshudian
 */
public class StreamAPI {

    @Test
    public void test1(){
        Arrays.asList(1,2,3,4,5).stream().filter(x -> x%2 == 0).forEach(System.out::println);
        System.out.println("............");

        int sum = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);
        System.out.println("............");

        int max = Arrays.asList(1,2,3,4,5,6).stream().max((a,b) -> a-b).get();
		System.out.println(max);
        System.out.println("............");

		int min = Arrays.asList(1,2,3,4,5,6).stream().min((a,b) -> a-b).get();
		System.out.println(min);
        System.out.println("............");

        Optional<Integer> op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findAny();
        System.out.println(op.get());
        System.out.println("............");

        op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).findFirst();
        System.out.println(op.get());
        System.out.println("............");

        op = Arrays.asList(1,2,3,4,5,6).stream().filter(x -> x%2 == 0).sorted((a,b) -> b-a).findFirst();
        System.out.println(op.get());
        System.out.println("............");

        Arrays.asList(11,3,8,5,10).stream().sorted().forEach(System.out::println);
        System.out.println("............");

        Arrays.asList(11,3,8,5,10).stream().sorted((a,b) -> b-a).forEach(System.out::println);
        System.out.println("............");

        Arrays.asList("cn", "admin", "net", "io").stream().sorted((a,b) -> a.length()-b.length()).forEach(System.out::println);;
        System.out.println("............");

    }


    @Test
    public void test2(){

        //从1-50里面的所有偶数找出来你，放到一个list里面
		List<Integer> list = Stream.iterate(1, x -> x + 1).limit(50).filter(x -> x%2 == 0).collect(Collectors.toList());
		System.out.println(list);

		//去重
		Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().distinct().forEach(System.out::println);

		Set<Integer> set = Arrays.asList(1, 3, 4, 2, 2, 5, 1).stream().collect(Collectors.toSet());
		System.out.println(set);

		List<Integer> list2 = Stream.iterate(1, x -> x + 1).limit(50).sorted((a,b) -> b-a).skip(20).limit(10).collect
                (Collectors.toList());
		System.out.println(list2);

        //把下列字符串分割，依次转换成int，然后求和
		String str = "11,22,33,44,55";
		int sum  = Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
		System.out.println(sum);

//		sum  = Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum();
//		System.out.println(sum);

		sum  = Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum();
		System.out.println(sum);


		String str2 = "tomcat,nginx,apahce,jetty";
//		Stream.of(str2.split(",")).map(x -> new User(x)).forEach(System.out::println);
		Stream.of(str2.split(",")).map(User::new).forEach(System.out::println);
//		Stream.of(str2.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
		Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        String str3 = "11,22,33,44,55";
        int sum3  = Stream.of(str3.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum();
        System.out.println(sum3);
    }

    //并行stream
    @Test
    public void test3(){
        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=5
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        //顺序执行
//        Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x -> {
//            System.out.println(Thread.currentThread().getName());
//        }).max(Integer::compare);

        //并行执行
        Optional<Integer> max = Stream.iterate(1, x -> x + 1).limit(200).peek(x -> {
            System.out.println(Thread.currentThread().getName());
        }).parallel().max(Integer::compare);

        System.out.println(max);
    }
}