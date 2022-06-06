package go.multithread.base.oo2_middle.demo002;
/**
 * 锁对象的改变问题
 * 对象本身已经改变，那么持有的锁就已经不同
 * @author Gao
 *
 */
public class ChangeLock {

	private String lock = "concurrent";
	
	private void method(){
		synchronized (lock) {
			try {
				System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
				lock = "change concurrent";
				Thread.sleep(2000);
				System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
	
		final ChangeLock changeLock = new ChangeLock();
		Thread t1 = new Thread(() -> changeLock.method(),"t1");
		Thread t2 = new Thread(()-> changeLock.method(),"t2");
        t1.start();
        try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		t2.start();

	}
}