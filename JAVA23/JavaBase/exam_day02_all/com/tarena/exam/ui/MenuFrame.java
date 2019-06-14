package com.tarena.exam.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tarena.exam.POJO.User;

/**
 * 主界面
 */
public class MenuFrame extends JFrame {
	private static final long serialVersionUID = 4912132724512378069L;
	public MenuFrame() {
		init();
	}
	private void init() {
		setSize(660, 450);
		setTitle("在线考试系统--主界面");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		add(createPane());
	}
	private Component createPane() {
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon image = 
			new ImageIcon(getClass().getResource("title.png"));
		JLabel top = new JLabel(image);
		JLabel buttom = 
			new JLabel("版权所有,盗版必究       ",JLabel.RIGHT);
		pane.add(top,BorderLayout.NORTH);
		pane.add(buttom,BorderLayout.SOUTH);
		pane.add(createCenter(),BorderLayout.CENTER);
		return pane;
	}
	JLabel loginInfo;
	private Component createCenter() {
		JPanel pane = new JPanel(new BorderLayout());
		loginInfo = new JLabel("欢迎XXX参加考试",JLabel.CENTER);
		pane.add(loginInfo,BorderLayout.NORTH);
		pane.add(createButtonPane(),BorderLayout.CENTER);
		return pane;
	}
	private Component createButtonPane() {
		JPanel pane = new JPanel(new FlowLayout());
		JButton start = 
			createButton("开始", "exam.png");
		JButton result = 
			createButton("考试成绩", "result.png");
		JButton rule = 
			createButton("考试规则", "message.png");
		JButton exit = 
			createButton("离开", "exit.png");
		pane.add(start);
		pane.add(result);
		pane.add(rule);
		pane.add(exit);
		return pane;
	}
	private JButton createButton(String name,String url){
		JButton button = 
			new JButton(name, 
					new ImageIcon(
							getClass().getResource(url)));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		return button;
		
	}
	public void updateInfo(User user){
		loginInfo.setText("欢迎"+user.getName()+"同学参加考试");
	}
	
}










