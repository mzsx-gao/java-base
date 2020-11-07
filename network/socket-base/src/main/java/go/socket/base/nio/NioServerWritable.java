package go.socket.base.nio;

/**
 * 类说明：nio通信服务端
 */
public class NioServerWritable {
    private static NioServerHandleWriteable nioServerHandle;

    public static void start(){

    }
    public static void main(String[] args){
        nioServerHandle = new NioServerHandleWriteable(12345);
        new Thread(nioServerHandle,"Server").start();
    }

}
