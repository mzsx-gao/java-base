package com.gao.socket.io.nio.demo2;

import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    private static AtomicInteger integer = new AtomicInteger();

    public static int getCount(){
        return integer.getAndAdd(1);
    }
}
