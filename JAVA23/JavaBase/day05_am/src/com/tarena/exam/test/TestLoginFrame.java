package com.tarena.exam.test;

import com.tarena.exam.POJO.POJOContext;
import com.tarena.exam.service.Service;
import com.tarena.exam.ui.LoginFrame;

public class TestLoginFrame {
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		Service service = new Service();
		POJOContext pojoContext = new POJOContext();
		loginFrame.setService(service);
		service.setLoginFrame(loginFrame);
		service.setPojoContext(pojoContext);
		
		loginFrame.setVisible(true);
	}

}
