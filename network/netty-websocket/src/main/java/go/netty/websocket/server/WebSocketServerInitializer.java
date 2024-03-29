package go.netty.websocket.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.ssl.SslContext;

/**
 * 类说明：增加handler
 */
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

    /*websocket访问路径*/
    private static final String WEBSOCKET_PATH = "/websocket";

    private final ChannelGroup group;

    private final SslContext sslCtx;

    public WebSocketServerInitializer(SslContext sslCtx, ChannelGroup group) {
        this.sslCtx = sslCtx;
        this.group = group;
    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new HttpObjectAggregator(65536));

        /*支持ws数据的压缩传输*/
        pipeline.addLast(new WebSocketServerCompressionHandler());

        pipeline.addLast(new WebSocketServerProtocolHandler(WEBSOCKET_PATH,
                null,true));

        /*浏览器访问的时候展示index页面*/
        pipeline.addLast(new ProcessWsIndexPageHandler(WEBSOCKET_PATH));

        /*对WS的数据进行处理*/
        pipeline.addLast(new ProcesssWsFrameHandler(group));

    }
}
