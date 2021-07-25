package go.concurrent.ch1.threadlocal;

import go.concurrent.tools.SleepTools;

/**
 * 类说明：ThreadLocal的线程不安全演示
 */
public class ThreadLocalUnsafe implements Runnable {

    public Number number = new Number(0);

    //加上static就会有线程安全问题，因为此时所有线程共享number这个实例，去掉static，每个线程new ThreadLocalUnsafe()是会
    //单独持有一个Number实例
//    public static Number number = new Number(0);

    public void run() {
        //每个线程计数加一
        number.setNum(number.getNum() + 1);
        //将其存储到ThreadLocal中
        value.set(number);
//        SleepTools.ms(2);
        //输出num值
        System.out.println(Thread.currentThread().getName() + "=" + value.get().getNum());
    }

    public static ThreadLocal<Number> value = new ThreadLocal<Number>() {
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new ThreadLocalUnsafe()).start();
        }
    }

    private static class Number {
        public Number(int num) {
            this.num = num;
        }

        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Number [num=" + num + "]";
        }
    }

}
