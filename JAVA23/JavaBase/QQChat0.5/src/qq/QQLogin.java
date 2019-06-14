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

		drawUI();// ������������

		// ���ڹرռ�����������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		this.setVisible(true);
	}

	public void drawUI() {

		labUser = new JLabel("�û���:");
		labPass = new JLabel("���룺");

		txtUser = new JTextField();
		txtPass = new JTextField();

		btnLogin = new JButton("��½");
		btnReg = new JButton("ע��");
		btnCancel = new JButton("ȡ��");

		// ע���¼�����
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
		if (e.getActionCommand().equals("��½")) {
			;
		} else if (e.getActionCommand().equals("ע��")) {
			;
		} else if (e.getActionCommand().equals("ȡ��")) {
			;
		}
	}

}
