package go.multithread.base.oo1_base.base004_synFunctionLock;

public class SynFunctionLockDemo {

    public static void main(String[] args) {

        Ticket t = new Ticket();
//		System.out.println("t:"+t);

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        t.flag = false;
        t2.start();
    }
}