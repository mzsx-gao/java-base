package com.gao.base_001.base006_singleDemo;

//饿汉式
public class SingleDemo {

	private static final SingleDemo s=new SingleDemo();
	private SingleDemo(){};
	public static SingleDemo getInstance(){
		return s;
	}
}
