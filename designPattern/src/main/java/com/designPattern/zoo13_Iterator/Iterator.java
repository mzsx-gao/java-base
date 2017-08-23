package com.designPattern.zoo13_Iterator;

public interface Iterator {
	
	public void first();

	public void next();

	public boolean isDone();

	public Object currentItem();
}