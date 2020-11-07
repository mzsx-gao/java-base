package go.multithread.base.oo1_base.base011_stopThreadDemo;

/*
一 :停止线程：
 1，stop方法。
 2，run方法结束。
 怎么控制线程的任务结束呢?
 任务中都会有循环结构，只要控制住循环就可以结束任务。
 控制循环通常就用定义标记来完成。

 但是如果线程处于了冻结状态，无法读取标记。如何结束呢？
 可以使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来，让线程具备cpu的执行资格。但是强制动作会发生InterruptedException，记得要处理

二:interrupt()方法详解:
 1:终止处于“阻塞状态”的线程
 当线程由于被调用了sleep(), wait(), join()等方法而进入阻塞状态；若此时调用线程的interrupt()将线程的中断标记设为true。
 由于处于阻塞状态，中断标记会被清除，同时产生一个InterruptedException异常。将InterruptedException放在适当的为止就能终止线程，
 2:终止处于“运行状态”的线程
  public void run() {
     while (!isInterrupted()) {
         // 执行任务...
     }
  }
  isInterrupted()是判断线程的中断标记是不是为true。当线程处于运行状态，并且我们需要终止它时；可以调用线程的interrupt()方法，使用线程的中断标记为true，即isInterrupted()
  会返回true。此时，就会退出while循环。
  注意：interrupt()并不会终止处于“运行状态”的线程！它会将线程的中断标记设为true

三：interrupted() 和 isInterrupted()的区别：
    interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。
    区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记
  */

class StopThread implements Runnable {
	private boolean flag = true;

	public synchronized void run() {
		while (flag) {
			try {
				wait();// t0 t1
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "....." + e);
				flag = false;
			}

			System.out.println(Thread.currentThread().getName() + "......++++");
		}
	}

	public void setFlag() {
		flag = false;
	}

    public static void main(String[] args) {
        StopThread st = new StopThread();

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        t1.start();
        t2.setDaemon(true);
        t2.start();

        for (int num =1; num <= 50 ;num ++) {
            if (num == 50) {
                // st.setFlag();
                t1.interrupt();
                // t2.interrupt();
                break;
            }
            System.out.println("main...." + num);
        }

        System.out.println("over");
    }
}
