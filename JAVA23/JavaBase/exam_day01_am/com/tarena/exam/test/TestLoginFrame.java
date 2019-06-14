package com.tarena.exam.test;

import com.tarena.exam.service.Service;
import com.tarena.exam.ui.LoginFrame;

public class TestLoginFrame {
	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		Service service = new Service();
		loginFrame.setService(service);
		service.setLoginFrame(loginFrame);
		loginFrame.setVisible(true);
	}

}
