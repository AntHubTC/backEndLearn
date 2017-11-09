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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

/*****
 * 
 * 接收来自服务端转发的数据
 * 
 */

public class ChatClient extends Frame {

	private TextField tfTxt = new TextField();
	private TextArea taContent = new TextArea();

	private Socket clientSocket = null;
	private DataOutputStream dos = null;
	private DataInputStream dis;
	private boolean bConnected = false;
	private Thread tRecv = new Thread(new ReceiveThread());

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		this.setLocation(400, 300);
		this.setSize(300, 300);
		this.setTitle("ChatSoft");

		/**** 添加组件 ****/
		this.setLayout(new BorderLayout());
		this.add(tfTxt, BorderLayout.SOUTH);
		this.add(taContent, BorderLayout.NORTH);
		this.pack();// 调整此窗口的大小，以适合其子组件的首选大小和布局。如果该窗口和/或其所有者还不可显示，则在计算首选大小之前都将变得可显示。在计算首选大小之后，将会验证该窗口。

		this.setVisible(true);
		this.tfTxt.addActionListener(new TFListener());
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				disconnect();
				System.exit(0);
			}
		});

		connect();// 连上服务器
		tRecv.start();
	}

	private class TFListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tfTxt) {
				String str = tfTxt.getText().trim();
				// taContent.setText(str);
				tfTxt.setText("");

				try {
					dos.writeUTF(str);
					dos.flush();
					// dos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	private void connect() {
		try {
			clientSocket = new Socket("127.0.0.1", 8888);
			dos = new DataOutputStream(clientSocket.getOutputStream());
			dis = new DataInputStream(clientSocket.getInputStream());
			bConnected = true;
			System.out.println("Connected");
		} catch (ConnectException e) {
			System.out.println("服务器还没启动！");
			System.exit(0);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			dos.close();
			dis.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * try { bConnected = false; tRecv.join();//合并到主线程 }catch
		 * (InterruptedException e) { 
		 * e.printStackTrace(); }finally{ try { dos.close(); dis.close();
		 * clientSocket.close(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
	}

	private class ReceiveThread implements Runnable {
		@Override
		public void run() {
			try {
				while (bConnected) {
					String str = dis.readUTF();
					System.out.print(str);
					taContent.setText(taContent.getText() + "\n" + str);
				}
			} catch (SocketException e) {
				System.out.println("已经退出!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
