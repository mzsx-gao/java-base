package go.multithread.base.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *   名称: Test.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/4/12 17:47
 *   @version [版本号, V1.0]
 *   @since 2018/4/12 17:47
 *   @author gaoshudian
 */
public class Test {
    public static void main(String[] args) throws Exception{

        List<Object> list = new ArrayList<>();
        list.add("nihao");
        list.add("shudian");
        list = null;
//        System.out.println(Thread.getAllStackTraces());
//        Thread.sleep(1000000);
    }

}