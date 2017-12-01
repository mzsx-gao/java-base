package com.gao.base_001.base006_singleDemo;

public class SingleDemo2 {

	private static SingleDemo2 s=null;
	private SingleDemo2(){};
	public static SingleDemo2 getInstance(){
		if(s==null){
			synchronized (SingleDemo2.class) {
				if(s==null){
					s=new SingleDemo2();
				}
			}
		}
		return s;
	}
}
