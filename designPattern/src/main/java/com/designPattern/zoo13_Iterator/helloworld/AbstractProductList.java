package com.designPattern.zoo13_Iterator.helloworld;

public abstract class AbstractProductList {

	private String[] productsName;

	public AbstractProductList(String[] productsName) {
		this.productsName = productsName;
	}

	public String[] getProductsName() {
		return this.productsName;
	}

	public abstract AbstractIterator getIterator();
}
