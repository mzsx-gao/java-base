package com.designPattern.oo9_mediator;

/**
 * 声卡类
 * @author gao
 *
 */
public class SoundCard extends Colleague {

	public SoundCard(Mediator mediator) {
		super(mediator);
	}
	/// 显示声音数据源
    public void ShowData(String data) {
       System.out.println("您正在听：" + data);
    }

}
