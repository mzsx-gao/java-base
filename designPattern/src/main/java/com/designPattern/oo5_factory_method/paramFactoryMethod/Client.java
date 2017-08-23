package com.designPattern.oo5_factory_method.paramFactoryMethod;

public class Client {

	public static void main(String[] args) {
		//创建需要使用的Creator对象
//		ExportOperate operate=new ExportOperate();
		ExportOperate operate=new ExportOperate2();
		//调用输出数据的功能方法
		operate.export(2,"测试数据");
	}
}
