package com.tarena.exam.service;

import javax.swing.JOptionPane;

import com.tarena.exam.ui.LoginFrame;

public class Service {
	LoginFrame loginFrame;
	public void login(int id,String password){
		if (1001 == id) {
			if ("1234".equals(password)) {
				JOptionPane.
				showMessageDialog(loginFrame, "登陆成功");
			}else{
				loginFrame.setError("密码错误!");
			}
		}else{
			loginFrame.setError("用户不存在! ");
		}
	}
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
}
