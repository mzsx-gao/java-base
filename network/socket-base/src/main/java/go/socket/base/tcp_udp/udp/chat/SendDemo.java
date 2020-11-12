package go.socket.base.tcp_udp.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendDemo {

    public static void main(String[] args) throws IOException {

        System.out.println("我是帅哥，正在和美女聊天....");
        DatagramSocket send = new DatagramSocket(8888);

        new Thread(new MsgRece(send)).start();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufr.readLine()) != null) {
            byte[] buf = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), 10001);
            send.send(dp);

            if ("886".equals(line))
                break;
        }
        send.close();
    }
}