package com.designPattern.oo8_prototype;

/**
 * 订单的接口
 * @author gao
 *
 */
public interface OrderApi {

	/**
	 * 获取订单产品数据
	 * @return
	 */
	public int getOrderProductNum();
	/**
	 * 设置订单产品数量
	 */
	public void setOrderProductNum(int num);
	/**
	 * 克隆方法
	 */
	public OrderApi cloneOrder();
}
