package go.concurrent.ch2.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * 类说明：演示Exchange用法
 */
public class UseExchange {

    private static final Exchanger<Set<String>> exchange = new Exchanger<>();

    public static void main(String[] args) {

        new Thread(() -> {
            Set<String> setA = new HashSet<>();//存放数据的容器
            try {
                /*添加数据
                 * set.add(.....)
                 * */
                setA.add("setA");
                setA = exchange.exchange(setA);//交换set
                System.out.println("线程一" + setA);
                /*处理交换后的数据*/
            } catch (InterruptedException e) {
            }
        }).start();

        new Thread(() -> {
            Set<String> setB = new HashSet<>();//存放数据的容器
            try {
                setB.add("setB");
                setB = exchange.exchange(setB);//交换set
                System.out.println("线程二" + setB);
                /*处理交换后的数据*/
            } catch (InterruptedException e) {
            }
        }).start();
    }
}