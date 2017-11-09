package com.tarena.exam.service;

import javax.swing.JOptionPane;

import com.tarena.exam.POJO.POJOContext;
import com.tarena.exam.POJO.User;
import com.tarena.exam.ui.LoginFrame;
import com.tarena.exam.ui.MenuFrame;

public class Service {
	LoginFrame loginFrame;
	POJOContext pojoContext;
	MenuFrame menuFrame;
	public void login(int id,String password){
		User user = pojoContext.getUser(id);
		if (id == 0) {
			loginFrame.setError("�û������Ͳ���ȷ!");
		}else{
			if (user == null) {
				loginFrame.setError("�û���������!");
			}else{
				String pass = user.getPassword();
				if (pass.equals(password)) {
//					JOptionPane.
//					showMessageDialog(loginFrame, "��½�ɹ�!");
					loginFrame.setVisible(false);
					menuFrame.updateInfo(user);
					menuFrame.setVisible(true);
				}else{
					loginFrame.setError("�������!");
				}
			}
		}
	}
	public void start() {
		loginFrame.setVisible(true);
	}
	
	
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void setPojoContext(POJOContext pojoContext) {
		this.pojoContext = pojoContext;
	}
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
}
