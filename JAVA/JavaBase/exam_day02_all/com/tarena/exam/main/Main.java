package com.tarena.exam.main;

import com.tarena.exam.POJO.POJOContext;
import com.tarena.exam.service.Service;
import com.tarena.exam.ui.LoginFrame;
import com.tarena.exam.ui.MenuFrame;

public class Main {
	public static void main(String[] args) {
		// �������
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		Service service = new Service();
		POJOContext pojoContext = new POJOContext();
		
		// ��װ���
		loginFrame.setService(service);
		service.setLoginFrame(loginFrame);
		service.setMenuFrame(menuFrame);
		service.setPojoContext(pojoContext);
		
		
		// ����ʼִ��
		service.start();
	}

}
