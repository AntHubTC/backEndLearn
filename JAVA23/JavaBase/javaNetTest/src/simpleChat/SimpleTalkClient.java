package simpleChat;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleTalkClient {
	
	public static void main(String[] args) {
		try {
			Socket s1 = new Socket("127.0.0.1",5432);
			DataInputStream dis = new DataInputStream(s1.getInputStream());
			final DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
			
			Frame myframe = new Frame("Client");
			Panel panelx = new Panel();
			final TextField input = new TextField(20);
			TextArea display = new TextArea(5,20);
			panelx.setLayout(new BorderLayout());
			panelx.add(input,BorderLayout.NORTH);
			panelx.add(display,BorderLayout.SOUTH);
			myframe.add(panelx);
			myframe.pack();
			
			new receiveThread(dis, display);
			input.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						dos.writeUTF("client:"+input.getText());
						input.setText("");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			//myframe.setSize(300, 300);
			myframe.setVisible(true);
			myframe.addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent arg0) {
					System.exit(0);
				}
				
			});
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class receiveThread extends Thread{
	
	DataInputStream dis;
	TextArea displayarea;
	
	public receiveThread(DataInputStream dis, TextArea displayarea) {
		this.dis = dis;
		this.displayarea = displayarea;
		this.start();
	}
	
	@Override
	public void run() {
		while(true){
			try{
				String str = new String(dis.readUTF());
				displayarea.append(str+"\n");
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
}
