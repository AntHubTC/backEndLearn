package com.tarena.exam.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.tarena.exam.service.Service;

public class LoginFrame extends JFrame{
	private static final long serialVersionUID = -4341143856190922764L;
	Service service;
	public LoginFrame() {
		init();
	}
	private void init() {
		setTitle("在线考试系统--登陆界面");
		setSize(350, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(createPanel());
	}
	private Component createPanel() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel label = 
			new JLabel("登 陆 系 统",JLabel.CENTER);
		pane.add(label,BorderLayout.NORTH);
		pane.add(createCenter(),BorderLayout.CENTER);
		pane.add(createSouth(),BorderLayout.SOUTH);
		return pane;
	}
	private Component createSouth() {
		JPanel pane = new JPanel(new FlowLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JButton login = new JButton("登陆");
		JButton regist = new JButton("注册");
		JButton cancel = new JButton("取消");
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				service.login(getID(), getPassword());
			}
		});
		pane.add(login);
		pane.add(regist);
		pane.add(cancel);
		getRootPane().setDefaultButton(login);
		return pane;
	}
	JLabel error;
	private Component createCenter() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		pane.add(createIdPswPane(),BorderLayout.NORTH);
		error = new JLabel("",JLabel.CENTER);
		pane.add(error,BorderLayout.SOUTH);
		return pane;
	}
	private Component createIdPswPane() {
		JPanel pane = 
			new JPanel(new GridLayout(2,1,0,8));
		pane.setBorder(new EmptyBorder(8, 0, 0, 0));
		pane.add(createIdPane());
		pane.add(createPswPane());
		return pane;
	}
	JPasswordField password;
	private Component createPswPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel label = new JLabel("密码:", JLabel.CENTER);
		pane.add(label,BorderLayout.WEST);
		password = new JPasswordField();
		pane.add(password,BorderLayout.CENTER);
		return pane;
	}
	JTextField id;
	private Component createIdPane() {
		JPanel pane = new JPanel(new BorderLayout());
		pane.setBorder(new EmptyBorder(8, 8, 8, 8));
		JLabel label = new JLabel("账号:", JLabel.CENTER);
		pane.add(label,BorderLayout.WEST);
		id = new JTextField();
		pane.add(id,BorderLayout.CENTER);
		return pane;
	}

	public int getID(){
		String str = id.getText();
		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
		}
		return i;
	}
	public void setError(String errorInfo) {
		error.setForeground(Color.RED);
		error.setText(errorInfo);
	}
	public String getPassword(){
		char[] ch = password.getPassword();
		return new String(ch);
	}
	public void setService(Service service) {
		this.service = service;
	}
}










