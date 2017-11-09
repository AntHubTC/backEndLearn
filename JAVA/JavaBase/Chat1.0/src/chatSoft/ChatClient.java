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
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/*****
 * 
 * ����˽��ͻ��˷�����������ת������һ���ͻ���
 * 
 */

public class ChatClient extends Frame {

	private TextField tfTxt = new TextField();
	private TextArea taContent = new TextArea();

	private Socket clentSocket = null;
	DataOutputStream dos = null;
	
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
				disconnect();
				System.exit(0);
			}
		});
		
		connect();//���Ϸ�����
	}

	private class TFListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == tfTxt)
			{
				String str = tfTxt.getText().trim();
				taContent.setText(str);
				tfTxt.setText("");
				
				try {
					dos.writeUTF(str);
					dos.flush();
					//dos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
	}

	private void connect()
	{
		try {
			clentSocket = new Socket("127.0.0.1",8888);
			dos = new DataOutputStream(clentSocket.getOutputStream());
System.out.println("Connected");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void disconnect()
	{
		try {
			dos.close();
			clentSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
