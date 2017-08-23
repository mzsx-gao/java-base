package com.designPattern.zoo11_observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象,它知道它的的观察者,并提供注册和删除观察者的接口
 * @author gao
 *
 */
public class Subject {

	/**
     * 用来保存注册的观察者对象，也就是报纸的订阅者
     */
    private List<Observer> readers = new ArrayList<Observer>();
 
    /**
     * 报纸的读者需要先向报社订阅，先要注册
     * @param reader 报纸的读者
     * @return 是否注册成功
     */
    public void attach(Observer reader) {
       readers.add(reader);
    }
    /**
     * 报纸的读者可以取消订阅
     * @param reader 报纸的读者
     * @return 是否取消成功
     */
    public void detach(Observer reader) {
       readers.remove(reader);
    }
    /**
     * 当每期报纸印刷出来后，就要迅速主动的被送到读者的手中，
     * 相当于通知读者，让他们知道
     */
    protected void notifyObservers() {
       for(Observer reader : readers){
           reader.update(this);
       }
    }
	
}
