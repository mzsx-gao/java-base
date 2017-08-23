package com.designPattern.oo1_simpleFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂类,用来创建API的对象
 * @author Gaoshudian
 *
 */
public class Factory {

	/**
	 * 具体创建API的方法,根据配置文件的参数来创建接口
	 */
	public static API createAPI(){
		Properties p=new Properties();
		InputStream in = null;
		try {
			in = Factory.class.getResourceAsStream("FactoryTest.properties");
			p.load(in);
		} catch (Exception e) {
			System.out.println("装载工厂配置文件出错了，具体的堆栈信息如下:");
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		API api=null;
		try {
			api=(API)Class.forName(p.getProperty("ImplClass")).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return api;
	}
}
