package com.designPattern.zoo24_visitor;


/**
 * 具体的访问者，实现对客户的偏好分析
 */
public class PredilectionAnalyzeVisitor implements Visitor {

    //根据过往购买的历史、潜在购买意向
    //以及客户所在行业的发展趋势、客户的发展预期等的分析
    public void visitEnterpriseCustomer(EnterpriseCustomer ec){
        System.out.println("现在对企业客户"+ec.getName() +"进行产品偏好分析");
    }

    public void visitPersonalCustomer(PersonalCustomer pc){
        System.out.println("现在对个人客户"+pc.getName() +"进行产品偏好分析");
    }
}