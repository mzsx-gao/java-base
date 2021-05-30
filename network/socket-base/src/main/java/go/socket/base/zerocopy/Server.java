package go.socket.base.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 传统IO读写案例的服务端
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //创建serversocket 对象--8089服务
        ServerSocket serverSocket = new ServerSocket(8089);
        //循环监听连接
        while (true){
            Socket socket = serverSocket.accept();//客户端发起网络请求---连接
            //创建输⼊流对象
            DataInputStream dataInputStream = new
                    DataInputStream(socket.getInputStream());
            try{
                byte[] bytes = new byte[1024];        //创建缓冲区字节数组
                while(true){
                    int readCount = dataInputStream.read(bytes, 0,
                            bytes.length);
                    if(readCount==-1){
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
