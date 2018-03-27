package com.designPattern.zoo16_templateMethod;

/**
 *   名称: LoginTemplate.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 17:55
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 17:55
 *   @author gaoshudian
 */
public abstract class LoginTemplate {
    public final boolean login(LoginModel lm){
        LoginModel dblm = this.findLoginUser(lm.getLoginId());
        if(dblm != null){
            String encryptPwd = this.encryptPwd(lm.getPwd());
            lm.setPwd(encryptPwd);
            return this.match(lm,dblm);
        }
        return false;
    }
    public abstract LoginModel findLoginUser(String loginId);

    public String encryptPwd(String pwd){
        return pwd;
    }
    public boolean match(LoginModel lm,LoginModel dblm){
        if(lm.getLoginId().equals(dblm.getLoginId()) &&lm.getPwd().equals(dblm.getPwd())){
            return true;
        }
        return false;
    }

}