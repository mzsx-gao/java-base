package com.designPattern.oo1_simpleFactory;

public class Client {

	public static void main(String[] args) {
		API api = Factory.createAPI();
		api.operation("小明");
	}
}
