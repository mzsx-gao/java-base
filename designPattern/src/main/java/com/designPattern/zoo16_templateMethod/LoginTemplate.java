package com.designPattern.zoo16_templateMethod;


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