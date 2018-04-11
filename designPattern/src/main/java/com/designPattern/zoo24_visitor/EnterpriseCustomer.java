package com.designPattern.zoo24_visitor;

/**
 *   名称: EnterpriseCustomer.java
 *   描述: 企业客户的实现
 *   类型: JAVA
 *   最近修改时间:2018/4/11 16:17
 *   @version [版本号, V1.0]
 *   @since 2018/4/11 16:17
 *   @author gaoshudian
 */
public class EnterpriseCustomer extends Customer{
    private String linkman;
    private String linkTelephone;
    private String registerAddress;

    public void accept(Visitor visitor) {
        //回调访问者对象的相应方法
        visitor.visitEnterpriseCustomer(this);
    }
}