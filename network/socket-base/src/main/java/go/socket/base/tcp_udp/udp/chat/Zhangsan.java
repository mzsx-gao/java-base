package go.socket.base.tcp_udp.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Zhangsan {

	public static void main(String[] args) throws IOException {

		System.out.println("我是张三，正在和李四聊天....");
		DatagramSocket rece = new DatagramSocket(10001);
		new Thread(new MsgRece(rece)).start();

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=bufr.readLine())!=null){

			byte[] buf = line.getBytes();
			DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("localhost"),8888);
			rece.send(dp);

			if("886".equals(line))
				break;
		}
		rece.close();
	}
}