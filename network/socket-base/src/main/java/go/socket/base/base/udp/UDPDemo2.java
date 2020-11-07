package go.socket.base.base.udp;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPDemo2 {

    /*
    建立UDP接收端的思路。
        1，建立udp socket服务,因为是要接收数据，必须要明确一个端口号。
        2，创建数据包，用于存储接收到的数据。方便用数据包对象的方法解析这些数据.
        3，使用socket服务的receive方法将接收的数据存储到数据包中。
        4，通过数据包的方法解析数据包中的数据。
        5，关闭资源
    */
    @Test
    public void receive() throws Exception{
        //1,建立udp socket服务。
        DatagramSocket ds = new DatagramSocket(10000);

        while(true){
            //2,创建数据包。
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);

            //3,使用接收方法将数据存储到数据包中。
            ds.receive(dp);//阻塞式的。

            //4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(),0,dp.getLength());

            System.out.println(ip+":"+port+":"+text);

        }
    }

    /*
     创建UDP传输的发送端思路：
         1，建立udp的socket服务。
         2，将要发送的数据封装到数据包中。
         3，通过udp的socket服务将数据包发送出去。
         4，关闭socket服务。
	*/
    public static void main(String[] args) throws IOException {

        System.out.println("发送端启动......");

        //1,udpsocket服务。使用DatagramSocket对象。
        DatagramSocket ds = new DatagramSocket(8888);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=bufr.readLine())!=null){
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("172.16.36.102"),10000);
            ds.send(dp);
            if("886".equals(line))
                break;
        }
        //4，关闭资源。
        ds.close();
    }
}