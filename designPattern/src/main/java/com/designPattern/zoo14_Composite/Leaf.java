package com.designPattern.zoo14_Composite;

public class Leaf extends Component {

	private String name = "";

	public Leaf(String name) {
		this.name = name;
	}

	public void printStruct(String preStr) {
		System.out.println(preStr + "-" + name);
	}
}
