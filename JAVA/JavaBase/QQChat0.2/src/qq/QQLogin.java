package qq;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QQLogin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame w = new JFrame();
		w.setSize(250, 125);
		
		JLabel labUser = new JLabel("用户名:");
		JLabel labPass = new JLabel("密码：");
		
		JTextField txtUser = new JTextField();
		JTextField txtPass = new JTextField();
		
		JButton btnLogin = new JButton("登陆");
		JButton btnReg = new JButton("注册");
		JButton btnCancel = new JButton("取消");
		
		JPanel panInput = new JPanel();
		
		panInput.setLayout(new GridLayout(2,2));
		panInput.add(labUser);
		panInput.add(txtUser);
		panInput.add(labPass);
		panInput.add(txtPass);
		
		JPanel panButton = new JPanel();
		
		panButton.setLayout(new FlowLayout());
		panButton.add(btnLogin);
		panButton.add(btnReg);
		panButton.add(btnCancel);
		
		w.setLayout(new BorderLayout());
		w.add(panInput,BorderLayout.NORTH);
		w.add(panButton,BorderLayout.SOUTH);
		
		w.setVisible(true);
		
		//窗口关闭监听，匿名类
		w.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

}
