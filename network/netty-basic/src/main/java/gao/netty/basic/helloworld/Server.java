package gao.netty.basic.helloworld;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server {

    public static void main(String[] args) {
       /*
        创建两个线程组
        1.boss线程组:用于处理服务器端接收客户端连接的
        2.worker线程组:进行网络通信的(网络读写的)
        一旦‘boss’接收到连接，就会把连接信息注册到‘worker’上。如何知道多少个线程已经被使用，如何映射到已经创建的Channels
        上都需要依赖于EventLoopGroup的实现，并且可以通过构造函数来配置他们的关系。
       */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //2 Netty用于启动NIO服务器的辅助启动类，目的是降低服务端的开发负责度。用于服务器通道的一系列配置
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup,workerGroup)              //绑定俩个线程组
        .channel(NioServerSocketChannel.class)		//指定NIO的模式
		.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc){
                //3 在这里配置具体数据接收方法的处理
                sc.pipeline().addLast(new ServerHandler());
            }
        });
        try{
            //4 异步绑定服务器,对sync()方法的调用将导致当前 Thread阻塞，一直到绑定操作完成为止
            ChannelFuture channelFuture = b.bind(8765).sync();
            //5 等待服务器监听端口关闭
            //该应用程序将会阻塞等待直到服务器的 Channel关闭（因为你在 Channel 的 CloseFuture 上调用了 sync()方法）
            channelFuture.channel().closeFuture().sync();
        }catch (InterruptedException e){

        }finally{
            //释放所有的资源，包括所有被创建的线程
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}