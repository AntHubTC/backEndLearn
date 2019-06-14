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

public class QQLogin implements ActionListener{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JFrame w = new JFrame();
		w.setSize(250, 125);
		
		JLabel labUser = new JLabel("�û���:");
		JLabel labPass = new JLabel("���룺");
		
		JTextField txtUser = new JTextField();
		JTextField txtPass = new JTextField();
		
		JButton btnLogin = new JButton("��½");
		JButton btnReg = new JButton("ע��");
		JButton btnCancel = new JButton("ȡ��");
		
		//ע���¼�����
		QQLogin e = new QQLogin();
		btnLogin.addActionListener(e);
		btnReg.addActionListener(e);
		btnCancel.addActionListener(e);
		
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
		
		//���ڹرռ�����������
		w.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("��½")){
			;
		} else if(e.getActionCommand().equals("ע��")){
			;
		} else if(e.getActionCommand().equals("ȡ��")){
			;
		}
	}

}
