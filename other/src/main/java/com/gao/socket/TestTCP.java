package com.gao.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *   名称: TestTCP.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/1/2 15:04
 *   @version [版本号, V1.0]
 *   @since 2018/1/2 15:04
 *   @author gaoshudian
 */
public class TestTCP {

    public static void main(String[] args) throws Exception{
        Socket socket=null;
        try {
            //对服务端发起连接请求
            socket=new Socket("172.16.36.180", 514);

            //给服务端发送响应信息
            OutputStream os=socket.getOutputStream();
            os.write("迷你号!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}