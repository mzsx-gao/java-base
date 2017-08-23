package com.designPattern.oo4_Singleton;

/**
 * 懒汉式
 * 
 * @author Gaoshudian
 * 
 */
public class LazybonesSingleton {

	private LazybonesSingleton() {
	}

	private static LazybonesSingleton instance = null;

	public static  LazybonesSingleton getInstance() {
		if (instance == null) {
			synchronized(LazybonesSingleton.class){
				if(instance == null){
					instance = new LazybonesSingleton();
				}
			}
		}
		return instance;
	}

	// 单例可以有自己的操作
	public void singletonOperation() {

	}

	// 单例可以有自己的属性
	private String singletonData;

	// 让外部通过这些方法来访问属性的值
	public String getSingletonData() {
		return singletonData;
	}

}
