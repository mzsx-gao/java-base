package gao.netty.basic.udp.unicast;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;

/**
 * 类说明：发送端
 */
public class UdpQuestionSide {

    public final static String QUESTION = "告诉我一句古诗";

    public void run(int port) {

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioDatagramChannel.class)/*UDP通信*/
                .handler(new QuestoinHandler());
            Channel channel = b.bind(0).sync().channel();
            channel.writeAndFlush(
                new DatagramPacket(
                    Unpooled.copiedBuffer(QUESTION, CharsetUtil.UTF_8),
                    new InetSocketAddress("127.0.0.1", port)
                )
            ).sync();
            if (!channel.closeFuture().await(15000)) {
                System.out.println("等待超时");
            }
        } catch (Exception e) {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new UdpQuestionSide().run(UdpAnswerSide.ANSWER_PORT);
    }
}
