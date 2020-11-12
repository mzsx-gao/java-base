package embedded;

import gao.netty.basic.embedded.FixedLengthFrameDecoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 类说明：测试入站
 */
public class FixedLengthFrameDecoderTest {
    @Test
    public void testFramesDecoded() {
        //创建一个 ByteBuf，并存储 9 字节
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }
        //拷贝一个新对象，在新对象上修改不会影响前对象
        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        /*返回false*/
        //将入站消息写到 EmbeddedChannel 中。如果可以通过 readInbound()方法从 EmbeddedChannel 中读取数据，则返回 true
        assertFalse(channel.writeInbound(input.readBytes(1)));
        assertFalse(channel.writeInbound(input.readBytes(1)));
        assertTrue(channel.writeInbound(input.readBytes(1)));

        assertTrue(channel.writeInbound(input.readBytes(6)));

        channel.finish();


        // read messages
        //读取所生成的消息，并且验证是否有 3 帧（切片），其中每帧（切片）都为 3 字节
        ByteBuf read = (ByteBuf) channel.readInbound();
        //和源进行比对
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buf.release();
    }

}
