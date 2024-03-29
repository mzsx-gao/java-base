package gao.jvm.demo.others;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * VM参数： -XX:+PrintGC -Xms30M -Xmx30M -Xmn10m -XX:SurvivorRatio=8 -XX:-UseCompressedOops
 */
public class StopWorld {

    /*不停往list中填充数据*/
    //就使用不断的填充 堆 -- 触发GC
    public static class FillListThread extends Thread{
        List<Object> list = new LinkedList<>();

        @Override
        public void run() {
            try {
                while(true){
                    for(int i=0;i<10;i++){
                        Object ol = new Object();
                        list.add(ol);
                    }
                    Thread.sleep(1);
                }

            } catch (Exception e) {
            }
        }
    }

    /*每100ms定时打印*/
    public static class TimerThread extends Thread{
        public final static long startTime = System.currentTimeMillis();
        @Override
        public void run() {
            try {
                while(true){
                    long t =  System.currentTimeMillis()-startTime;
                   // System.out.println(t/1000+"."+t%1000);
                    Thread.sleep(100); //0.1s
                }

            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        //填充对象线程和打印线程同时启动
        FillListThread myThread = new FillListThread(); //造成GC，造成STW
        TimerThread timerThread = new TimerThread(); //时间打印线程
        myThread.start();
        timerThread.start();
    }

}
