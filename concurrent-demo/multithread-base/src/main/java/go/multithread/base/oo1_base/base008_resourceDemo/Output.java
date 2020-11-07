package go.multithread.base.oo1_base.base008_resourceDemo;

public class Output implements Runnable {

	Resource r;
	Output(Resource r) {
		this.r = r;
	}
	public void run() {
		while (true) {
			r.out();
		}
	}
}
