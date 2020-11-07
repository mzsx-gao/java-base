package go.socket.base;

/**
 *   名称: SingleTon3.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/30 16:03
 *   @version [版本号, V1.0]
 *   @since 2018/3/30 16:03
 *   @author gaoshudian
 */
public class SingleTon3 {

    private static class Inner{
        private static SingleTon3 instance = new SingleTon3();
    }

    public static SingleTon3 getInstance(){
        return Inner.instance;
    }

    private SingleTon3(){};


}