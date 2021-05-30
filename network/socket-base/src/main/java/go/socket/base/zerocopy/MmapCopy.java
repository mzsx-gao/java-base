package go.socket.base.zerocopy;

import sun.misc.Cleaner;
import sun.nio.ch.DirectBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/**
 * RocketMQ中的MMAP
 */
public class MmapCopy
{
    public static String path = "D:\\DTLFolder";//需要内存映射的文件目录
    public static void main( String[] args ) throws Exception
    {
        //映射的文件
        File file1 = new File(path, "1");
        //映射文件的fileChannel对象（操作文件，）
        FileChannel fileChannel = new RandomAccessFile(file1, "rw").getChannel();
        //fileChanne 定义了map方法，MMAP的映射  1k
        MappedByteBuffer mmap = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        // 向mmap 写入数据
        mmap.put("king".getBytes());
        //刷新写入磁盘
        mmap.flip();
        byte[] bb = new byte[4];
        //从mmap中读取文件
        mmap.get(bb,0,4);
        System.out.println(new String(bb));
        //解除MMAP
        unmap(mmap);
    }

    private static void unmap(MappedByteBuffer bb) {
        Cleaner cl = ((DirectBuffer)bb).cleaner();
        if (cl != null)
            cl.clean();
    }
}