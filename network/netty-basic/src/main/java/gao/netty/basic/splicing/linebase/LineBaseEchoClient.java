package gao.netty.basic.splicing.linebase;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;

/**
 * 将消息分为消息头和消息体，消息头中包含表示消息总长度（或者消息体长度） 的字段，通常设计思路为消息头的
 * 第一个字段使用 int32 来表示消息的总长度，使用 LengthFieldBasedFrameDecoder
 */
public class LineBaseEchoClient {

    private final String host;

    public LineBaseEchoClient(String host) {
        this.host = host;
    }

    public void start() throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();/*线程组*/
        try {
            final Bootstrap b = new Bootstrap();;/*客户端启动必须*/
            b.group(group)/*将线程组传入*/
                    .channel(NioSocketChannel.class)/*指定使用NIO进行网络传输*/
                    .remoteAddress(new InetSocketAddress(host,LineBaseEchoServer.PORT))/*配置要连接服务器的ip地址和端口*/
                    .handler(new ChannelInitializerImp());
            ChannelFuture f = b.connect().sync();
            System.out.println("已连接到服务器.....");
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    private static class ChannelInitializerImp extends ChannelInitializer<Channel> {

        @Override
        protected void initChannel(Channel ch) throws Exception {
            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
            ch.pipeline().addLast(new LineBaseClientHandler());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new LineBaseEchoClient("127.0.0.1").start();
    }
}
