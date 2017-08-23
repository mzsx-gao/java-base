package com.designPattern.zoo13_Iterator.helloworld;

public class ProductList extends AbstractProductList {

	public ProductList(String[] productsName) {
		super(productsName);
	}

	@Override
	public AbstractIterator getIterator() {
		return new MyIterator(this);
	}

}
