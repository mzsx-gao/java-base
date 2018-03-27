package com.jdk8.stream;

/**
 *   名称: Person.java
 *   描述:
 *   类型: JAVA
 *   最近修改时间:2018/3/27 16:39
 *   @version [版本号, V1.0]
 *   @since 2018/3/27 16:39
 *   @author gaoshudian
 */
public class Person {
    private String name;

    public static Person build(String name) {
        Person p = new Person();
        p.setName(name);
        return p;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}