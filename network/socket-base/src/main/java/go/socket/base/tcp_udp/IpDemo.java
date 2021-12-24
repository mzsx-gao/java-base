package go.socket.base.tcp_udp;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类的使用
 */
public class IpDemo {

    @Test
    public void test1() throws UnknownHostException{
        //获取本地主机ip地址对象
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        //获取其它主机的ip地址对象
        ip = InetAddress.getByName("www.baidu.com");

        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
    }
}