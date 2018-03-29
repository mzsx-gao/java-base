package com.designPattern.zoo18_state;

/**
 *   名称: Client.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/28 14:33
 *   @version [版本号, V1.0]
 *   @since 2018/3/28 14:33
 *   @author gaoshudian
 */
public class Client {
    public static void main(String[] args) {
        VoteManager vm = new VoteManager();
        for(int i=0;i<8;i++){
            vm.vote("u1", "A");
        }
    }

}