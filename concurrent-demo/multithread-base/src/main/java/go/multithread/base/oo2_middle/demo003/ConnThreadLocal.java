package go.multithread.base.oo2_middle.demo003;

public class ConnThreadLocal {

	public static ThreadLocal<String> th = new ThreadLocal<String>();
	
	public void setTh(String value){
		th.set(value);
	}
	public void getTh(){
		System.out.println(Thread.currentThread().getName() + ":" + ConnThreadLocal.th.get());
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final ConnThreadLocal ct = new ConnThreadLocal();

        Thread t1 = new Thread(()->{
            ct.setTh("张三");
            ct.getTh();
        },"t1");
        Thread t2 = new Thread(()->{
            try {
                Thread.sleep(1000);
                ct.getTh();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2");
		t1.start();
		t2.start();
	}
	
}