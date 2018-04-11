package com.designPattern.zoo24_visitor;

/**
 *   名称: PersonalCustomer.java
 *   描述: 个人客户的实现
 *   类型: JAVA
 *   最近修改时间:2018/4/11 16:19
 *   @version [版本号, V1.0]
 *   @since 2018/4/11 16:19
 *   @author gaoshudian
 */

public class PersonalCustomer extends Customer{
    private String telephone;
    private int age;

    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitPersonalCustomer(this);
    }
}