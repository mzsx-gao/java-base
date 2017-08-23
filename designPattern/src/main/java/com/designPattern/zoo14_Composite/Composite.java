package com.designPattern.zoo14_Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

	private List<Component> childComponents = null;

	private String name = "";

	public Composite(String name) {

		this.name = name;
	}

	public void addChild(Component child) {
		if (childComponents == null) {
			childComponents = new ArrayList<>();
		}
		childComponents.add(child);
	}

	@Override
	public void printStruct(String preStr) {
		// 先把自己输出去
		System.out.println(preStr + "+" + this.name);
		if (this.childComponents != null) {
			// 添加一个空格，表示向后缩进一个空格
			preStr += " ";

			for (Component c : childComponents) {
				c.printStruct(preStr);
			}
		}
	}

}
