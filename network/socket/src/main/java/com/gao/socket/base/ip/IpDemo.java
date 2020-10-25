package com.gao.socket.base.ip;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *   名称: IpDemo.java
 *   描述: InetAddress类的使用
 *   类型: JAVA
 *   最近修改时间:2018/7/16 13:00
 *   @version [版本号, V1.0]
 *   @since 2018/7/16 13:00
 *   @author gaoshudian
 */
public class IpDemo {

    @Test
    public void test1() throws UnknownHostException{
        //获取本地主机ip地址对象
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        //获取其它主机的ip地址对象
        ip = InetAddress.getByName("www.baidu.com");

        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }
}