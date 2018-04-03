package com.designPattern.zoo17_strategy;

/**
 *   名称: Client.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/28 10:46
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 10:46
 *   @author gaoshudian
 */
public class Client {
    public static void main(String[] args) {

        //1：选择并创建需要使用的策略对象
        Strategy strategy = new LargeCustomerStrategy();
        //2：创建上下文
        Price ctx = new Price(strategy);
        //3：计算报价
        double quote = ctx.quote(1000);
        System.out.println("向客户报价："+quote);
    }
}