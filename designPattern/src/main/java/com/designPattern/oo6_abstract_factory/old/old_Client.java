package com.designPattern.oo6_abstract_factory.old;

public class old_Client {

	public static void main(String[] args) {

		//创建装机工程师对象
		old_ComputerEngineer engineer=new old_ComputerEngineer();
		//告诉装机工程师自己选择的配件,让装机工程师组装电脑
		engineer.makeComputer(1, 2);
	}

}
