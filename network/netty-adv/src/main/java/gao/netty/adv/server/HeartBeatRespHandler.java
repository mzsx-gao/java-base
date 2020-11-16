package gao.netty.adv.server;


import gao.netty.adv.vo.MessageType;
import gao.netty.adv.vo.MyHeader;
import gao.netty.adv.vo.MyMessage;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 类说明：心跳处理完成
 */
public class HeartBeatRespHandler extends ChannelInboundHandlerAdapter {

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		MyMessage message = (MyMessage) msg;
		/*是不是心跳请求*/
		if(message.getMyHeader()!=null &&message.getMyHeader().getType()==MessageType.HEARTBEAT_REQ.value()){
			/*心跳应答报文*/
			MyMessage heartBeatResp = buildHeatBeat();
			ctx.writeAndFlush(heartBeatResp);
			ReferenceCountUtil.release(msg);
		}else{
			ctx.fireChannelRead(msg);
		}
    }

    private MyMessage buildHeatBeat() {
		MyMessage message = new MyMessage();
		MyHeader myHeader = new MyHeader();
		myHeader.setType(MessageType.HEARTBEAT_RESP.value());
		message.setMyHeader(myHeader);
		return message;
    }

}
