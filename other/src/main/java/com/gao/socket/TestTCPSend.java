package com.gao.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *   名称: TestTCPSend.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/1/2 15:09
 *   @version [版本号, V1.0]
 *   @since 2018/1/2 15:09
 *   @author gaoshudian
 */
public class TestTCPSend {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket=null;
        Socket socket=null;
        String msg="hello client,I am server..";
        try {
            //构造ServerSocket实例，指定端口监听客户端的连接请求
            serverSocket=new ServerSocket(514);
            //建立跟客户端的连接
            socket=serverSocket.accept();

            //向客户端发送消息
            OutputStream os=socket.getOutputStream();
            os.write(msg.getBytes());
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //操作结束，关闭socket
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}