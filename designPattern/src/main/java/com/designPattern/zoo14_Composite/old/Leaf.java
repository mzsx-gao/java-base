package com.designPattern.zoo14_Composite.old;

public class Leaf {

	private String name="";
	public Leaf(String name){
		this.name=name;
	}
	public void printStruct(String preStr){
		System.out.println(preStr+"-"+name);
	}
}
