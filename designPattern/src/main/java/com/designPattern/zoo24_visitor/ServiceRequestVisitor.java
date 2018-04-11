package com.designPattern.zoo24_visitor;

/**
 * 具体的访问者，实现客户提出服务请求的功能
 */
public class ServiceRequestVisitor implements Visitor {
    //企业客户提出的具体服务请求
    public void visitEnterpriseCustomer(EnterpriseCustomer ec){
        System.out.println(ec.getName()+"企业提出服务请求");
    }

    //个人客户提出的具体服务请求
    public void visitPersonalCustomer(PersonalCustomer pc){
        System.out.println("客户"+pc.getName()+"提出服务请求");
    }
}