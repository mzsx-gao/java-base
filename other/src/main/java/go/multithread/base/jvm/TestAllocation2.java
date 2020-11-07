package go.multithread.base.jvm;

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

    private static final int _1MB = 1024*1024;

    public static void main(String[] args){
        byte[] allocation1 , allocation2 , allocation3 , allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[6 * _1MB];
    }
}