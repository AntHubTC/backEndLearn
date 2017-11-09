package qq;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QQLogin extends JFrame implements ActionListener {

	private JLabel labUser;
	private JLabel labPass;
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnReg;
	private JButton btnCancel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QQLogin w = new QQLogin();
	}

	public QQLogin() {
		this.setSize(250, 125);

		drawUI();// 画出整个界面

		// 窗口关闭监听，匿名类
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setVisible(true);
	}

	public void drawUI() {

		labUser = new JLabel("用户名:");
		labPass = new JLabel("密码：");

		txtUser = new JTextField();
		txtPass = new JTextField();

		btnLogin = new JButton("登陆");
		btnReg = new JButton("注册");
		btnCancel = new JButton("取消");

		// 注册事件侦听
		btnLogin.addActionListener(this);
		btnReg.addActionListener(this);
		btnCancel.addActionListener(this);

		JPanel panInput = new JPanel();

		panInput.setLayout(new GridLayout(2, 2));
		panInput.add(labUser);
		panInput.add(txtUser);
		panInput.add(labPass);
		panInput.add(txtPass);

		JPanel panButton = new JPanel();

		panButton.setLayout(new FlowLayout());
		panButton.add(btnLogin);
		panButton.add(btnReg);
		panButton.add(btnCancel);

		this.setLayout(new BorderLayout());
		this.add(panInput, BorderLayout.NORTH);
		this.add(panButton, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("登陆")) {
			;
		} else if (e.getActionCommand().equals("注册")) {
			;
		} else if (e.getActionCommand().equals("取消")) {
			;
		}
	}

}
