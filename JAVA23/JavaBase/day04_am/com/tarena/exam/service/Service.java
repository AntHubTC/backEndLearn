package com.tarena.exam.service;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.tarena.exam.POJO.POJOContext;
import com.tarena.exam.POJO.User;
import com.tarena.exam.ui.LoginFrame;
import com.tarena.exam.ui.MenuFrame;

public class Service {
	LoginFrame loginFrame;
	POJOContext pojoContext;
	MenuFrame menuFrame;
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public void setPojoContext(POJOContext pojoContext) {
		this.pojoContext = pojoContext;
	}
	public void setMenuFrame(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
	
	public void login(int id,String password){
		User user = pojoContext.getUser(id);
		if (id == 0) {
			loginFrame.setError("用户名类型不正确!");
		}else{
			if (user == null) {
				loginFrame.setError("用户名不存在!");
			}else{
				String pass = user.getPassword();
				if (pass.equals(password)) {
//					JOptionPane.
//					showMessageDialog(loginFrame, "登陆成功!");
					loginFrame.setVisible(false);
					menuFrame.updateInfo(user);
					menuFrame.setVisible(true);
				}else{
					loginFrame.setError("密码错误!");
				}
			}
		}
	}
	public void show() {
		loginFrame.setVisible(true);
	}
	
	public void exit(JFrame frame, String info){
		//确认对话框(0:是,1:否,2:取消)
		int n = JOptionPane.showConfirmDialog(frame, info);
		if (n == 0) {
			System.exit(0);
		}
	}
	
	boolean tag = false;//考试标示符,false代表未考试
	/**
	 * 开始考试
	 * 
	 */
	public void start() {
		if (tag) {
			System.out.println("您已经考过试!");
//			JOptionPane.showMessageDialog(menuFrame, "您已经考过试!");
		}else{
			System.out.println("开始考试");
			tag = true;
		}
	}
	/**
	 * 查看分数
	 */
	public void result() {
		if (!tag) {
			System.out.println("还为考试");
//			JOptionPane.showMessageDialog(menuFrame, "您还没有考试!");
		}else{
			System.out.println("查看分数");
		}
	}
}
