package com.designPattern.oo9_mediator;

/**
 * 中介者具体类
 * 
 * @author gao
 *
 */
public class ConcreteMediator extends Mediator {

	private CDDriver cdDriver;
	private CPU cpu;
	private VideoCard video;
	private SoundCard sound;

	public void SetCDDriver(CDDriver cdDriver) {
		this.cdDriver = cdDriver;
	}

	public void SetCPU(CPU cpu) {
		this.cpu = cpu;
	}

	public void SetVideoCard(VideoCard video) {
		this.video = video;
	}

	public void SetSoundCard(SoundCard sound) {
		this.sound = sound;
	}

	public void Change(Colleague colleague) {
		if (colleague == cdDriver) {
			openCDAndReadData((CDDriver) colleague);
		} else if (colleague == cpu) {
			OpenCPU((CPU) colleague);
		}
	}

	/// 打开CD，并读取数据
	private void openCDAndReadData(CDDriver cs) {
		// 获取光驱读取的数据
		String data = cdDriver.GetData();
		// 把这些数据传递给CPU进行处理
		this.cpu.ExecuteData(data);
	}

	/// CPU处理
	private void OpenCPU(CPU cpu) {
		// 获取数据
		String videoData = cpu.GetVideioData();
		String soundData = cpu.GetSoundData();

		// 显示数据
		this.video.ShowData(videoData);
		this.sound.ShowData(soundData);

	}

}
