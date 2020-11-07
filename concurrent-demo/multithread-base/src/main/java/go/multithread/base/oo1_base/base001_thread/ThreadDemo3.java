package go.multithread.base.oo1_base.base001_thread;

/*
	创建线程的第一种方式:继承Thread类。
	
	创建线程的第二种方式：实现Runnable接口。
	
	1,定义类实现Runnable接口。
	2，覆盖接口中的run方法，将线程的任务代码封装到run方法中。
	3，通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递。
		为什么？因为线程的任务都封装在Runnable接口子类对象的run方法中。
		所以要在线程对象创建时就必须明确要运行的任务。
	
	4，调用线程对象的start方法开启线程。
	
	
	实现Runnable接口的好处：
	1，将线程的任务从线程的子类中分离出来，进行了单独的封装。
		按照面向对象的思想将任务封装成对象。
	2，避免了java单继承的局限性。
	
	所以，创建线程的第二种方式较为常用。
*/
public class ThreadDemo3 {

	public static void main(String[] args) {

		Demo3 d=new Demo3();
		Thread t1=new Thread(d);
		Thread t2=new Thread(d);
		t1.start();
		t2.start();
		
	}

}
