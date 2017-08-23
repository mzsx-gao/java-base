package com.designPattern.oo6_abstract_factory.old;

import com.designPattern.oo6_abstract_factory.GAMainboard;
import com.designPattern.oo6_abstract_factory.MSIMainboard;
import com.designPattern.oo6_abstract_factory.MainboardApi;

/**
 * 创建主板的简单工厂
 * @author GaoSD
 *
 */
public class old_MainboardFactory {

	public static MainboardApi createMainboardApi(int type){
		MainboardApi mainboard = null;
		if(type == 1){
			mainboard = new GAMainboard(1156);
		}else if(type==2){
			mainboard=new MSIMainboard(939);
		}
		return mainboard;
	}
}
