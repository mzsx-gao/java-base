package com.designPattern.oo4_Singleton;

/**
 * 饿汉式
 * @author 高书电
 *
 * 2015年12月1日
 */
public class HungrySingleton {

	private static HungrySingleton instance = new HungrySingleton();

	private HungrySingleton() {
	}

	public static HungrySingleton getInstance() {
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
