package com.designPattern.zoo16_templateMethod;

/**
 *   名称: NormalLoginModel.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 17:53
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 17:53
 *   @author gaoshudian
 */
public class NormalLoginModel extends LoginModel{

    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}