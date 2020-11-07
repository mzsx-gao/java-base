package go.socket.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gao on 2018/4/14.
 */
public class JConsoleTest {

    byte[] b1 = new byte[128*1024];

    public static void main(String[] args) {
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("start...");
        fill(1000);

    }
    private static void fill(int n){
        List<JConsoleTest> jlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            jlist.add(new JConsoleTest());
        }
    }
}
