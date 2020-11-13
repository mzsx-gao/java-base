package go.socket.base.tcp_udp.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MsgRece implements Runnable {

    private DatagramSocket ds;

    public MsgRece(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run(){
        try {
            while (true) {
                // 2,创建数据包。
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);

                // 3,使用接收方法将数据存储到数据包中。
                ds.receive(dp);// 阻塞式的。

                // 4，通过数据包对象的方法，解析其中的数据,比如，地址，端口，数据内容。
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                String name;
                if(port==8888){
                    name="李四";
                }else{
                    name="张三";
                }
                System.err.println(name +"::  " + text);
                if (text.equals("886")) {
                    System.err.println(ip + "....退出聊天室");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}