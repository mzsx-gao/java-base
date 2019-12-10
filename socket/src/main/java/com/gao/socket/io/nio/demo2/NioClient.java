package com.gao.socket.io.nio.demo2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClient {

    //通道管理器  
    private Selector selector;

    /**
     * 获得一个Socket通道，并对该通道做一些初始化的工作
     */
    public void initClient(String ip, int port) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        this.selector = Selector.open();

        // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调用channel.finishConnect()才能完成连接
        channel.connect(new InetSocketAddress(ip, port));
        System.out.println("client...注册OP_CONNECT事件");
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     */
    public void listen() throws IOException {
        while (true) {
            selector.select();
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();
                handler(key);
            }
        }
    }

    //处理请求
    private void handler(SelectionKey key) throws IOException{
        if (key.isConnectable()) {
            System.out.println("client...key.isConnectable()");
            SocketChannel channel = (SocketChannel) key.channel();
            // 如果正在连接，则完成连接
            if (channel.isConnectionPending()) {
                channel.finishConnect();
            }
            channel.configureBlocking(false);
            channel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
            channel.register(this.selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            System.out.println("client...key.isReadable()");
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readData = channel.read(buffer);
            if (readData > 0) {
                String msg = new String(buffer.array(), "UTF-8").trim();
                System.out.println("client收到信息：" + msg);
            } else {
                System.out.println("server关闭咯...");
                //SelectionKey对象会失效，这意味着Selector再也不会监控与它相关的事件
                key.cancel();
            }
        }
    }

    /**
     * 启动客户端测试
     */
    public static void main(String[] args) throws IOException {
        NioClient client = new NioClient();
        client.initClient("localhost", 8888);
        client.listen();
    }

}