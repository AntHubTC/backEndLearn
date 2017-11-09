package com.tarena.exam.main;

import com.tarena.exam.POJO.POJOContext;
import com.tarena.exam.service.Service;
import com.tarena.exam.ui.LoginFrame;
import com.tarena.exam.ui.MenuFrame;

public class Main {
	public static void main(String[] args) {
		// 创建组件
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		Service service = new Service();
		POJOContext pojoContext = new POJOContext();
		
		// 组装组件
		loginFrame.setService(service);
		service.setLoginFrame(loginFrame);
		service.setMenuFrame(menuFrame);
		service.setPojoContext(pojoContext);
		
		
		// 程序开始执行
		service.start();
	}

}
