package com.tarena.exam.service;

import javax.swing.JOptionPane;

import com.tarena.exam.ui.LoginFrame;

public class Service {
	LoginFrame loginFrame;
	public void login(int id,String password){
		if (1001 == id) {
			if ("1234".equals(password)) {
				JOptionPane.
				showMessageDialog(loginFrame, "��½�ɹ�");
			}else{
				loginFrame.setError("�������!");
			}
		}else{
			loginFrame.setError("�û�������! ");
		}
	}
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
}
