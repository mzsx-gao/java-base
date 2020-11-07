package go.multithread.base.jvm.slot;

/**
 * Created by gao on 2018/6/3.
 */
public class SlotTest {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a=0;
        System.gc();
    }
}
