package go.multithread.base.oo1_base.base008_resourceDemo;

/*
 线程间通讯：多个线程在处理同一资源，但是任务却不同。
 
等待/唤醒机制。 
涉及的方法：
1，wait(): 让线程处于冻结状态，被wait的线程会被存储到线程池中。
2，notify():唤醒线程池中一个线程(任意).
3，notifyAll():唤醒线程池中的所有线程。

这些方法都必须定义在同步中。
因为这些方法是用于操作线程状态的方法。
必须要明确到底操作的是哪个锁上的线程。


为什么操作线程的方法wait notify notifyAll定义在了Object类中？ 

因为这些方法是监视器的方法。监视器其实就是锁。
锁可以是任意的对象，任意的对象调用的方式一定定义在Object类中。

*/
public class ResourceDemo {

	public static void main(String[] args) {
		// 创建资源。
		Resource r = new Resource();
		// 创建任务。
		Input in = new Input(r);
		Output out = new Output(r);
		// 创建线程，执行路径。
		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);
		// 开启线程
		t1.start();
		t2.start();
	}
}
