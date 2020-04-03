package com.jdk8.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
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
     计算 min、max、count、 average、sum
     匹配 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny
     汇聚 reduce
     收集器 toArray collect

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

    //测试Stream.map()方法
    @Test
    public void mapTest(){

        String str = "tomcat,nginx,apahce,jetty";

//        Stream.of(str.split(",")).map(new Function<String, Object>() {
//            public Person apply(String t){
//                return Person.build(t);
//            }
//        }).forEach(System.out::println);
//		Stream.of(str.split(",")).map(x -> Person.build(x)).forEach(System.out::println);
        Stream.of(str.split(",")).map(Person::build).forEach(System.out::println);


//		Stream.of(str.split(",")).map(x -> new User(x)).forEach(System.out::println);
        Stream.of(str.split(",")).map(User::new).forEach(System.out::println);


        //把下列字符串分割，依次转换成int，然后求和
        String str2 = "11,22,33,44,55";
        int sum  = Stream.of(str2.split(",")).mapToInt(x -> Integer.valueOf(x)).sum();
        System.out.println(sum);

        sum  = Stream.of(str2.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum();
        System.out.println(sum);

        sum  = Stream.of(str2.split(",")).mapToInt(Integer::valueOf).sum();
        System.out.println(sum);
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

    @Test
    public void test4(){

        Map<String, String> systems = new LinkedHashMap<>();
        systems.put("ch.qos.logback.core.Appender", "org.springframework.boot.logging.logback.LogbackLoggingSystem");
        systems.put("org.apache.logging.log4j.core.impl.Log4jContextFactory",
                "org.springframework.boot.logging.log4j2.Log4J2LoggingSystem");
        systems.put("java.util.logging.LogManager", "org.springframework.boot.logging.java.JavaLoggingSystem");

        Map<String, String> SYSTEMS = Collections.unmodifiableMap(systems);
        Optional<String> result = SYSTEMS.entrySet().stream()
                .filter((entry) -> "ch.qos.logback.core.Appender".equals(entry.getKey()))
                .map((entry) -> "LogbackLoggingSystem").findFirst();
        System.out.println(result.get());

        //list转map
        List<User> userlist = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            userlist.add(new User("张三"+i));
        }
        Map<String,String> map =userlist.stream().collect(Collectors.toMap(User::getName,User::getName));
        System.out.println(map);

    }

    /*
    return SYSTEMS.entrySet().stream().filter((entry) -> ClassUtils.isPresent(entry.getKey(), classLoader))
				.map((entry) -> get(classLoader, entry.getValue())).findFirst()
				.orElseThrow(() -> new IllegalStateException("No suitable logging system located"));
     */
}