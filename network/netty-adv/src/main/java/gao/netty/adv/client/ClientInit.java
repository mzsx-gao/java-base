package gao.netty.adv.client;

import gao.netty.adv.kryocodec.KryoDecoder;
import gao.netty.adv.kryocodec.KryoEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * 类说明：客户端Handler的初始化
 */
public class ClientInit extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new LoggingHandler(LogLevel.INFO));
        /*粘包半包问题*/
        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535,
                0,2,0,
                2));
        ch.pipeline().addLast(new LengthFieldPrepender(2));

        /*序列化相关*/
        ch.pipeline().addLast(new KryoDecoder());
        ch.pipeline().addLast(new KryoEncoder());

        /**
         * 处理心跳超时:
         * 引入 Netty 的 ReadTimeoutHandler 机制，当一定周期内（默认值 50s）没有读取到对方任何消息时，会触发一个 ReadTimeoutException
         * 这时客户端可以重新发起连接
         */
        ch.pipeline().addLast(new ReadTimeoutHandler(15));

        ch.pipeline().addLast(new LoginAuthReqHandler());
        //心跳，测试时为了不让一直打印心跳日志，可以暂时注释掉
        ch.pipeline().addLast(new HeartBeatReqHandler());
    }
}
