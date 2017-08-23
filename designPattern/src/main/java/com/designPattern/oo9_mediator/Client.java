package com.designPattern.oo9_mediator;

public class Client {

	public static void main(String[] args) {
		//1.创建中介者——主板对象
        ConcreteMediator mediator = new ConcreteMediator();

        //2.创建同事类
        CDDriver cd = new CDDriver(mediator);//光驱
        CPU cpu = new CPU(mediator);//cpu
        VideoCard videocard = new VideoCard(mediator);//显卡
        SoundCard soundcard = new SoundCard(mediator);//声卡
        //3.让中介知道所有的同事
        mediator.SetCDDriver(cd);
        mediator.SetCPU(cpu);
        mediator.SetVideoCard(videocard);
        mediator.SetSoundCard(soundcard);

        //4.开始看电影
        cd.ReadCD();
	}
}
