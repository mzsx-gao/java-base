package com.gao.socket.nio.helloworld;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioClient implements Runnable{

    //通道管理器  
    private Selector selector;

    public NioClient(int port) throws Exception{
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        this.selector = Selector.open();

        // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调用channel.finishConnect()才能完成连接
        channel.connect(new InetSocketAddress(port));
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    @Override
    public void run(){
        while (true) {
            try {
                selector.select();
                Iterator ite = this.selector.selectedKeys().iterator();
                while (ite.hasNext()) {
                    SelectionKey key = (SelectionKey) ite.next();
                    ite.remove();
                    handler(key);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //处理请求
    private void handler(SelectionKey key) throws IOException{
        if (key.isConnectable()) {
            System.out.println("client...连接建立");
            SocketChannel channel = (SocketChannel) key.channel();
            // 如果正在连接，则完成连接
            if (channel.isConnectionPending()) {
                channel.finishConnect();
            }
            channel.configureBlocking(false);
            //接收控制台输入,写入到SocketChannel
            Scanner scanner = new Scanner(System.in);
            channel.write(ByteBuffer.wrap(scanner.next().getBytes()));
            channel.register(this.selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
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
    public static void main(String[] args) throws Exception {
        new Thread(new NioClient(8765)).start();
    }

}