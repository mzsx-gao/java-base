package com.gao.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 *   名称: HeapOOM.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/4/3 14:53
 *   @version [版本号, V1.0]
 *   @since 2018/4/3 14:53
 *   @author gaoshudian
 */
public class HeapOOM {
    static class OOMObject{

    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }


    }
}