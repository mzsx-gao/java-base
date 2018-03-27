package com.designPattern.zoo16_templateMethod;

/**
 *   名称: LoginModel.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 17:52
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 17:52
 *   @author gaoshudian
 */
public class LoginModel {

    private String loginId;
    private String pwd;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}