package gao.jvm.demo.ex9.stream;

import java.util.*;

/**
 * Stream使用入门
 */
public class StreamDemo {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("张三", "李四", "王老五", "李三", "刘老四", "王小二", "张四", "张五六七");

        //找出姓张的最长名字的长度
        List ll = new ArrayList();
        for (String name : names) {
            if (name.startsWith("张")) {
                ll.add(name.length());
            }
        }
        System.out.println((int) Collections.max(ll));

        //使用stream一行代码解决了。
        int maxLenZ = names.stream()
            .filter(name -> name.startsWith("张"))
            .mapToInt(String::length)
            .max()
            .getAsInt();
        System.out.println(maxLenZ);
    }
}