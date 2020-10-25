package com.gao.socket.base.tcp;

import org.junit.Test;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPDemo {

    /*
	 建立tcp服务端的思路：
	 1，创建服务端socket服务。通过ServerSocket对象。
	 2，服务端必须对外提供一个端口，否则客户端无法连接。
	 3，获取连接过来的客户端对象。
	 4，通过客户端对象获取socket流读取客户端发来的数据并打印在控制台上。
	 5，关闭资源。关客户端，关服务端。
     */
    @Test
    public void server() throws Exception{

        //1创建服务端对象。
        ServerSocket ss = new ServerSocket(10002);

        //2,获取连接过来的客户端对象。
        Socket s = ss.accept();//阻塞式.

        String ip = s.getInetAddress().getHostAddress();

        //3，通过socket对象获取输入流，要读取客户端发来的数据
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);
        String text = new String(buf,0,len);
        System.out.println(ip+":"+text);

        s.close();
        ss.close();
    }

    /*
	 Tcp传输，客户端建立的过程。
	 1，创建tcp客户端socket服务。使用的是Socket对象。建议该对象一创建就明确目的地。要连接的主机。
	 2，如果连接建立成功，说明数据传输通道已建立。该通道就是socket流 ,是底层建立好的。
	    既然是流，说明这里既有输入，又有输出。想要输入或者输出流对象，可以找Socket来获取。可以通过getOutputStream(),和getInputStream()来获取两个字节流。
	 3，使用输出流，将数据写出。
	 4，关闭资源。
	*/
    @Test
    public void client() throws Exception{
        //创建客户端socket服务。
        Socket socket = new Socket("172.16.36.102",10002);

        //获取socket流中的输出流。
        OutputStream out = socket.getOutputStream();

        //使用输出流将指定的数据写出去。
        out.write("tcp演示：哥们又来了!".getBytes());

        //关闭资源。
        socket.close();
    }
}