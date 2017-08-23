package com.designPattern.zoo14_Composite.old;

import java.util.ArrayList;
import java.util.Collection;

public class Composite {

	private Collection<Composite> childComposite = new ArrayList<>();

	private Collection<Leaf> childLeaf = new ArrayList<>();

	private String name = "";

	public Composite(String name) {
		this.name = name;
	}

	public void addComposite(Composite c) {
		this.childComposite.add(c);
	}

	public void addLeaf(Leaf leaf) {
		this.childLeaf.add(leaf);
	}

	public void printStruct(String preStr) {
		// 先把自己输出去
		System.out.println(preStr + "+" + this.name);
		// 然后添加一个空格,表示向后缩进一个空格,输出自己包含的叶子对象
		preStr += " ";
		for (Leaf leaf : childLeaf) {
			leaf.printStruct(preStr);
		}
		for (Composite c : childComposite) {
			c.printStruct(preStr);
		}
	}

}
