package gao.netty.adv.server;

import gao.netty.adv.kryocodec.KryoDecoder;
import gao.netty.adv.kryocodec.KryoEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * channelHandler链处理
 */
public class ServerInit extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) {

        /*粘包半包问题*/
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0,2,0, 2));
        ch.pipeline().addLast(new LengthFieldPrepender(2));

        /*序列化相关*/
        ch.pipeline().addLast(new KryoDecoder());//入栈
        ch.pipeline().addLast(new KryoEncoder());//出栈

        /**
         * 处理心跳超时:
         * 引入 Netty 的 ReadTimeoutHandler 机制，当一定周期内（默认值 50s）没有读取到对方任何消息时，会触发一个 ReadTimeoutException
         * 这时我们需要主动关闭链路，如果是客户端，可以重新发起连接;如果是服务端，释放资源，清除客户端登录缓存信息，等待客户端重连
         */
        ch.pipeline().addLast(new ReadTimeoutHandler(15));

        ch.pipeline().addLast(new LoginAuthRespHandler());
        ch.pipeline().addLast(new HeartBeatRespHandler());
        ch.pipeline().addLast(new ServerBusiHandler());

    }
}