package gao.jvm.demo.ex7.init;

/**
 * 父类
 */
public class SuperClazz {
	static 	{
		System.out.println("SuperClass init！");
	}
	public static int value=123;
	public static final String HELLOWORLD="hello king";
	public static final int WHAT = value;
}
