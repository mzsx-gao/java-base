package com.designPattern.oo2_facade;

/**
 * 代码生成子系统的外观对象
 * 
 * @author Gaoshudian
 * 
 */
public class Facade {

	/**
	 * 客户端所需要的，一个简单的调用代码生成的功能
	 */
	public void generate() {
		new Presentation().generate();
		new Business().generate();
		new DAO().generate();
	}

}
