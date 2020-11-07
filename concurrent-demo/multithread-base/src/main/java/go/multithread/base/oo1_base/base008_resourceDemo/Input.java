package go.multithread.base.oo1_base.base008_resourceDemo;

public class Input implements Runnable {

	Resource r;
	Input(Resource r) {
		this.r = r;
	}
	public void run() {
		int x = 0;
		while (true) {
			if (x == 0) {
				r.set("mike", "nan");
			} else {
				r.set("丽丽", "女女女女女女");
			}
			x = (x + 1) % 2;
		}
	}
}
