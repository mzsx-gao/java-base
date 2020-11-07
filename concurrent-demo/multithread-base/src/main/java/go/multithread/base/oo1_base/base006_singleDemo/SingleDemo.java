package go.multithread.base.oo1_base.base006_singleDemo;

//饿汉式
public class SingleDemo {

	private static final SingleDemo s=new SingleDemo();
	private SingleDemo(){};
	public static SingleDemo getInstance(){
		return s;
	}
}
