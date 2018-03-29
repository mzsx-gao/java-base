package com.designPattern.oo9_mediator;

/**
 * CPU类
 * @author gao
 *
 */
public class CPU extends Colleague {

	public CPU(Mediator mediator) {
		super(mediator);
	}
	/// 分解出来的视频数据
    private String videioData = null;

    /// 分解出来的声音数据
    private String soundData = null;

    /// 获取分解出来的视频数据
    public String GetVideioData() {
        return this.videioData;
    }

    /// 获取分解出来的声音数据
    public String GetSoundData() {
        return this.soundData;
    }

    /// 处理数据
    public void ExecuteData(String data) {
        String[] ss = data.split(",");
        this.videioData = ss[0];
        this.soundData = ss[1];

        //通知主板，CPU工作已完成
        this.GetMediator().Change(this);
    }

}
