package com.gao;

import java.net.InetAddress;

public class UseInet {

    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        for(InetAddress address1 : allByName){
            System.out.println(address1);
        }

        System.out.println("hello".getBytes().length);

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
