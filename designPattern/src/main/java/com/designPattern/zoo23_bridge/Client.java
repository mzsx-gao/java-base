package com.designPattern.zoo23_bridge;

/**
 *   名称: Client.java
 *   描述: 客户端测试类
 *   类型: JAVA
 *   最近修改时间:2018/4/9 17:24
 *   @version [版本号, V1.0]
 *   @since 2018/4/9 17:24
 *   @author gaoshudian
 */

public class Client {
    public static void main(String[] args) {
        //创建具体的实现对象
        MessageImplementor impl = new MessageSMS();
        //创建一个普通消息对象
        AbstractMessage m = new CommonMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
        //创建一个紧急消息对象
        m = new UrgencyMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
        //创建一个特急消息对象
        m = new SpecialUrgencyMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");

        //把实现方式切换成手机短消息，然后再实现一遍
        impl = new MessageMobile();
        m = new CommonMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
        m = new UrgencyMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
        m = new SpecialUrgencyMessage(impl);
        m.sendMessage("请喝一杯茶", "小李");
    }
}