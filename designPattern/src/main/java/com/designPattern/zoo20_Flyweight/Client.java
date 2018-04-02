package com.designPattern.zoo20_Flyweight;

/**
 *   名称: Client.java
 *   描述:测试类
 *   类型: JAVA
 *   最近修改时间:2018/3/30 16:22
 *   @version [版本号, V1.0]
 *   @since 2018/3/30 16:22
 *   @author gaoshudian
 */
public class Client {
    public static void main(String[] args) {
        //需要先登录，然后再判断是否有权限
        SecurityMgr mgr = SecurityMgr.getInstance();
        mgr.login("张三");
        mgr.login("李四");
        boolean f1 = mgr.hasPermit("张三","薪资数据","查看");
        boolean f2 = mgr.hasPermit("李四","薪资数据","查看");

        System.out.println("f1=="+f1);
        System.out.println("f2=="+f2);
        for(int i=0;i<3;i++){
            mgr.login("张三"+i);
            mgr.hasPermit("张三"+i,"薪资数据","查看");
        }
    }
}