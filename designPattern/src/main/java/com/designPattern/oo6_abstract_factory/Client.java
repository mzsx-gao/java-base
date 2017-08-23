package com.designPattern.oo6_abstract_factory;

public class Client {

	public static void main(String[] args) {

		//创建装机工程师对象
		ComputerEngineer engineer=new ComputerEngineer();
		AbstractFactory schema=new Schema2();
		engineer.makeComputer(schema);
	}

}
