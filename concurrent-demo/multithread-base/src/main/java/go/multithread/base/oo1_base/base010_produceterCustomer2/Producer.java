package go.multithread.base.oo1_base.base010_produceterCustomer2;

public class Producer implements Runnable{

	private Resource r;
	public Producer(Resource r) {
		this.r = r;
	}
	public void run() {
		while(true) {
		    try{
                r.set("雪糕");
            }catch (Exception e){
		        e.printStackTrace();
            }
		}
	}
}
