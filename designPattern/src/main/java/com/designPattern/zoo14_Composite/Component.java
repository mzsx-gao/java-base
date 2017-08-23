package com.designPattern.zoo14_Composite;

/**
 * 抽象的组件对象
 * 
 * @author gaoshudian
 * @date 2017年4月7日 下午5:05:08
 */
public abstract class Component {

	// 输出组件自身的名称
	public abstract void printStruct(String preStr);

	// 向组合对象中加入组件对象
	public void addChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	// 从组合对象中移除某个组件对象
	public void removeChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	// 返回某个索引对应的组件对象
	public Component getChildrern(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
}
