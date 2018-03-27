package com.designPattern.zoo16_templateMethod;

/**
 *   名称: Client.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 18:01
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 18:01
 *   @author gaoshudian
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