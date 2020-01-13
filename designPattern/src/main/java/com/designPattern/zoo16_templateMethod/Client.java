package com.designPattern.zoo16_templateMethod;

/**
 * 模板方法模式
 */
public class Client {

    public static void main(String[] args) {
        //准备登录人的信息
        NormalLoginModel nlm = new NormalLoginModel();
        nlm.setLoginId("testUser");
        nlm.setPwd("testpwd");
        nlm.setQuestion("testQuestion");
        nlm.setAnswer("testAnswer");
        //准备用来进行判断的对象
        LoginTemplate lt3 = new NormalLogin();
        //进行登录测试
        boolean flag3 = lt3.login(nlm);
        System.out.println("可以进行普通人员加强版登录="+flag3);
    }
}