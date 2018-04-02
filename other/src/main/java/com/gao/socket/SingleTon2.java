package com.gao.socket;

/**
 *   名称: SingleTon2.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/30 16:02
 *   @version [版本号, V1.0]
 *   @since 2018/3/30 16:02
 *   @author gaoshudian
 */
public class SingleTon2 {

    private static SingleTon2 instance = null;
    private SingleTon2(){};

    public static  SingleTon2 getInstance(){
        if(instance == null){
            synchronized (SingleTon2.class){
                if(instance == null){
                    instance = new SingleTon2();
                }
            }
        }
        return instance;
    }

}