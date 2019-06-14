package chatSoft;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*****
 * 
 * ����˷�����
 * 
 */

public class ChatClient extends Frame {

	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}
	
	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.setTitle("ChatSoft");

		/**** ������ ****/
		this.setLayout(new BorderLayout());
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();// �����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ��֡�����ô��ں�/���������߻�������ʾ�����ڼ�����ѡ��С֮ǰ������ÿ���ʾ���ڼ�����ѡ��С֮�󣬽�����֤�ô��ڡ�

		this.setVisible(true);
		this.tfTxt.addActionListener(new TFListener());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}

	private class TFListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tfTxt)
			{
				String s = tfTxt.getText().trim();
				taContent.setText(s);
				tfTxt.setText("");
			}
		}
		
	}

}
