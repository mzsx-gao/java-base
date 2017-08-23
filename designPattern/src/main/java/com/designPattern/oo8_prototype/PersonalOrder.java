package com.designPattern.oo8_prototype;

/**
 * 个人订单对象
 * @author gao
 *
 */
public class PersonalOrder implements OrderApi {

	//订购人员姓名
	private String customerName;
	//产品id
	private String productId;
	//订单产品数量
	private int orderProductNum=0;
	
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

	@Override
	public void setOrderProductNum(int num) {

		this.orderProductNum=num;
	}

	@Override
	public String toString() {
		return "PersonalOrder [customerName=" + customerName + ", productId=" + productId + ", orderProductNum="
				+ orderProductNum + "]";
	}

	@Override
	public OrderApi cloneOrder() {
		//创建一个新的订单实例，然后把本实例的数据复制过去
		PersonalOrder order=new PersonalOrder();
		order.setCustomerName(this.getCustomerName());
		order.setOrderProductNum(this.getOrderProductNum());
		order.setProductId(this.getProductId());
		return order;
	}
	

}
