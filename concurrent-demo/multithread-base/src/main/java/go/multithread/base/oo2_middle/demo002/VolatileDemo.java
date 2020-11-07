package go.multithread.base.oo2_middle.demo002;

/**
  volatile关键字的主要作用是使变量在多个线程间可见

  JAVA中每一个线程都会有一块工作内存区,其中存放着所有线程共享的主内存中的变量值得拷贝。当线程执行时，他在自己的工作内存中操作这些变量。
  为了存取一个共享的变量,一个线程通常先获取锁并去清除它的内存工作区,把这些共享变量从所有线程的共享内存区中正确的装入到它自己所有的工作内存区中,
  当线程解锁时保证该工作内存区中变量的值写回到共享内存中

  如果isRunning变量不加volatile关键字，则在主线程里改变isRunning变量的值后，rt线程读取不到,
  加了isRunning关键字后,则当变量改变时强制线程执行引擎去主内存里读取
  @author Gao
 */
public class VolatileDemo extends Thread{

	private volatile boolean isRunning = true;
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	public void run(){
		System.out.println("进入run方法..");
		while(isRunning == true){
			//..
		}
		System.out.println("线程停止");
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileDemo rt = new VolatileDemo();
		rt.start();
		Thread.sleep(1000);
		rt.setRunning(false);
		System.out.println("isRunning的值已经被设置了false");
		Thread.sleep(1000);
		System.out.println(rt.isRunning);
	}
	
}
