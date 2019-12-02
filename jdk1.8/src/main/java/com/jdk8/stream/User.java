package com.jdk8.stream;

/**
 *   名称: User.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 16:39
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 16:39
 *   @author gaoshudian
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}