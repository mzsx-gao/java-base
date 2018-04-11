package com.designPattern.zoo24_visitor;

/**
 *   名称: Customer.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/4/11 16:16
 *   @version [版本号, V1.0]
 *   @since 2018/4/11 16:16
 *   @author gaoshudian
 */
public abstract class Customer {
    private String customerId;
    private String name;

    /**
     * 接受访问者的访问
     *
     * @param visitor 访问者对象
     */
    public abstract void accept(Visitor visitor);


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}