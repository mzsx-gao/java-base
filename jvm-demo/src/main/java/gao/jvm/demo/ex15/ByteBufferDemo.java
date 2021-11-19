package gao.jvm.demo.ex15;

import java.nio.ByteBuffer;

/**
 应该是没有显示的设置-XX:MaxDirectMemorySize 参数， 通过 ByteBuffer 能够分配的直接内存空间大小就是堆的最大的
 可使用的大小。
 堆的最大的可使用的大小= 堆的最大值- 一个 Survivor 的大小(浪费的空间)

 * VM Args：-XX:MaxDirectMemorySize=100m
 * 限制最大直接内存大小100m
 * -XX:MaxDirectMemorySize=128m - 可以分配
 * -Xmx128m - 不可以分配
 * -Xmx135m -Xmn100m -XX:SurvivorRatio=8 - 不可以分配
 * -Xmx138m -Xmn100m -XX:SurvivorRatio=8 - 可以分配
 */
public class ByteBufferDemo {
    static ByteBuffer bb;

    public static void main(String[] args) {
        //直接分配128M的直接内存
        bb = ByteBuffer.allocateDirect(128 * 1024 * 1024);
    }
}