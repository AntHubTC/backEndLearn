package chatSoft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;
import java.util.*;


public class ChatServer {

	private static boolean started = false;

	private static ServerSocket ss = null;
	private static Socket s = null;

	List<Client> clients = new ArrayList<Client>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	public void start()
	{
		try {
			ss = new ServerSocket(8888);
		} catch (BindException e) {
			System.out.println("端口使用中…………");
			System.out.println("请关闭正在使用的端口");
			System.exit(0);
		}// 8888TCP的端口号
		catch (Exception e) {
			started = false;
			e.printStackTrace();
		}

		started = true;

		try {
			while (started) {
				s = ss.accept();
				System.out.println("a clent connected");
				Client c = new Client(s);
				new Thread(c).start();
				clients.add(c);

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ss != null)
					ss.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	// Client类客服端在服务端的包装，线程类
	class Client implements Runnable {
		private Socket s;
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean bConnected = false;
		
		public Client(Socket s) {
			this.s = s;
			bConnected = true;
			try {
				this.dis = new DataInputStream(s.getInputStream());
				this.dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String str)
		{
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try
			{
				while (bConnected) {
					String str = dis.readUTF();
					
					for(int i=0; i<clients.size(); i++)
					{
						Client c = clients.get(i);
						c.send(str);
					}
					
				}
			} catch (EOFException e) {
				System.out.println("a client disconnect");
				e.printStackTrace();
			} catch (IOException e) {
			} finally {
				bConnected = false;                      
				try {
					if (dis != null)
						dis.close();
					if (s != null)
						s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
}
