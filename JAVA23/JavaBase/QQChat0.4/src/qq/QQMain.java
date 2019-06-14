package qq;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQMain extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		QQMain m = new QQMain();
	}

	private JTextField txtMess;
	private JComboBox cmbUser;
	private JButton btnSend;
	private JTextArea txtContent;
	private JScrollPane spContent;
	private JPanel panSmall;
	private JPanel panBig;
	
	public QQMain()
	{
		this.setSize(300, 400);
		txtMess = new JTextField();
		
		cmbUser = new JComboBox();
		btnSend = new JButton("发送");
		
		txtContent = new JTextArea();
		spContent = new JScrollPane();
		
		panSmall = new JPanel();
		panSmall.setLayout(new GridLayout(1,2));
		panSmall.add(cmbUser);
		panSmall.add(btnSend);
		
		panBig = new JPanel();
		panBig.setLayout(new GridLayout(2,1));
		
		panBig.add(txtMess);
		panBig.add(panSmall);
		
		this.setLayout(new BorderLayout());
		this.add(panBig,BorderLayout.NORTH);
		this.add(spContent,BorderLayout.SOUTH);
		
		//窗口关闭监听，匿名类
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
