package qq;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class QQMain {
	
	public static void main(String[] args) {
		JFrame w = new JFrame();
		w.setSize(300, 400);
		JTextField txtMess = new JTextField();
		
		JComboBox cmbUser = new JComboBox();
		JButton btnSend = new JButton("发送");
		
		JTextArea txtContent = new JTextArea();
		JScrollPane spContent = new JScrollPane();
		
		JPanel panSmall = new JPanel();
		panSmall.setLayout(new GridLayout(1,2));
		panSmall.add(cmbUser);
		panSmall.add(btnSend);
		
		JPanel panBig = new JPanel();
		panBig.setLayout(new GridLayout(2,1));
		
		panBig.add(txtMess);
		panBig.add(panSmall);
		
		w.setLayout(new BorderLayout());
		w.add(panBig,BorderLayout.NORTH);
		w.add(spContent,BorderLayout.SOUTH);
		
		//窗口关闭监听，匿名类
		w.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		w.setVisible(true);
	}

}
