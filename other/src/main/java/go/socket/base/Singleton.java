package go.socket.base;

/**
 *   名称: Singleton.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/30 16:00
 *   @version [版本号, V1.0]
 *   @since 2018/3/30 16:00
 *   @author gaoshudian
 */
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton(){};

    public static Singleton getInstance(){
        return instance;
    }

}