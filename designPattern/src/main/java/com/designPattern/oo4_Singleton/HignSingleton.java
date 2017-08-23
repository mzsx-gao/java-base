package com.designPattern.oo4_Singleton;

public class HignSingleton {

	/**
	 * 类级别的内部类,也就是静态的成员式内部类,该内部类的实例与外部类的实例
	 * 没有绑定关系,而且只有被调用到时才会装载,从而实现了延迟加载
	 * @author Gaoshudian
	 *
	 */
	private static class SingletonHolder{
		/**
		 * 静态初始化器,由JVM来保证线程安全
		 */
		private static HignSingleton instance=new HignSingleton();
		
	}
	/**
	 * 私有化构造方法
	 */
	private HignSingleton(){
		
	}
	public static HignSingleton getInstance(){
		return SingletonHolder.instance;
	}
}
