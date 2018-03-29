package com.designPattern.oo9_mediator;

/**
 * 显卡类
 * @author gao
 *
 */
public class VideoCard extends Colleague {

	public VideoCard(Mediator mediator) {
		super(mediator);
	}

	public void ShowData(String data) {
        System.out.println("您正在看：" + data);
    }
}
