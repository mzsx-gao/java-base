package com.designPattern.oo9_mediator;

/**
 * 光驱类
 * @author gao
 *
 */
public class CDDriver extends Colleague {

	public CDDriver(Mediator mediator){
		super(mediator);
	}
    /// 光驱读取出来的数据
    private String Data = null;

    /// 获取光驱读取出来的数据
    public String GetData()
    {
        return this.Data;
    }

    public void ReadCD()
    {
        //逗号前是视频数据，逗号后是声音数据
        this.Data = "这是视频数据,这是声音数据";
        //通知主板，自己的状态反生了改变
        this.GetMediator().Change(this);
    }
}
