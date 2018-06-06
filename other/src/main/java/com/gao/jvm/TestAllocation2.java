package com.gao.jvm;

/**
 *   名称: TestAllocation.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/4/11 10:30
 *   @version [版本号, V1.0]
 *   @since 2018/4/11 10:30
 *   @author gaoshudian
 */
public class TestAllocation2 {

    public static void main(String[] args) throws Exception{
        byte[] allocation1 = new byte[1*1024*1024/4];
        byte[] allocation2 = new byte[4*1024*1024];
        byte[] allocation3 = new byte[4*1024*1024];
        allocation3 = null;
        allocation3 = new byte[4*1024*1024];
    }
}