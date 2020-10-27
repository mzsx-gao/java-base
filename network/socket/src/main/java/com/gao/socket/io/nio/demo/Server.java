package com.gao.socket.io.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable{
	//1 多路复用器（管理所有的通道）
	private Selector seletor;
	//2 建立读缓冲区
	private ByteBuffer readBuf = ByteBuffer.allocate(1024);

	public Server(int port){
		try {
			//1 打开多路复用器
			this.seletor = Selector.open();
			//2 打开服务器通道
			ServerSocketChannel ssc = ServerSocketChannel.open();
			//3 设置服务器通道为非阻塞模式
			ssc.configureBlocking(false);
			//4 绑定地址
			ssc.bind(new InetSocketAddress(port));
			//5 把服务器通道注册到多路复用器上，并且"OP_ACCEPT(接收连接)"事件
			ssc.register(this.seletor, SelectionKey.OP_ACCEPT);
			System.out.println("Server start, port :" + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true){
			try {
				//1 获取当前有哪些事件,select()方法为阻塞方法
                this.seletor.select();
                //2 返回多路复用器已经选择的结果集
				Iterator<SelectionKey> keys = this.seletor.selectedKeys().iterator();
				//3 进行遍历
				while(keys.hasNext()){
					//4 获取一个选择的元素
					SelectionKey key = keys.next();
					//5 直接从容器中移除就可以了
					keys.remove();
					//6.处理事件
					if(key.isValid()){
						handleInput(key);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//处理事件
	private void handleInput(SelectionKey key) throws IOException {
		//7 如果为"OP_ACCEPT"事件,处理新接入的客户端的请求
		if(key.isAcceptable()){
			System.out.println("server端accept方法...");
			//1 获取关心当前事件的Channel(服务端通道)
			ServerSocketChannel ssc =  (ServerSocketChannel) key.channel();
			//2 接受连接，获取一个SocketChannel
			SocketChannel sc = ssc.accept();
			//3 将SocketChannel设置为"非阻塞"模式
			sc.configureBlocking(false);
			//4 SocketChannel注册到多路复用器上，并设置关注"OP_READ"事件
			sc.register(this.seletor, SelectionKey.OP_READ);
		}
		//8 如果为“OP_READ”事件,处理对端发送的数据
		if(key.isReadable()){
			System.out.println("server端read方法...");
			//1 清空缓冲区旧的数据
			this.readBuf.clear();
			//2 获取之前注册的SocketChannel通道对象
			SocketChannel sc = (SocketChannel) key.channel();
			//3 从通道里读取数据，写入readBuf
			int count = sc.read(this.readBuf);
			if(count>0){
				//5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
				this.readBuf.flip();
				//6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
				byte[] bytes = new byte[this.readBuf.remaining()];
				//7 接收缓冲区数据
				this.readBuf.get(bytes);
				//8 打印结果
				String body = new String(bytes).trim();
				System.out.println("Server端收到的数据 : " + body);
				// 9..可以写回给客户端数据
				returnToClient(sc);
			}else{
				key.cancel();
				sc.close();
			}
		}
	}

    //响应客户端数据
    private void returnToClient(SocketChannel sc) throws IOException {
		String response = "服务端返回给客户端数据";
		byte[] respbytes = response.getBytes();
		ByteBuffer buffer = ByteBuffer.allocate(respbytes.length);
		buffer.put(respbytes);
		buffer.flip();
		//从buffer中读取数据写入到SocketChannel中
		sc.write(buffer);
	}

	public static void main(String[] args) {
		new Thread(new Server(8765)).start();
	}
}
