package chatSoft;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	private static boolean started = false;
	private static boolean bConnected = false;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8888);//8888TCPµÄ¶Ë¿ÚºÅ
			started = true;
			while(true)
			{
				Socket s = ss.accept();
System.out.println("a clent connected");
				bConnected = true;
				DataInputStream dis = new DataInputStream(s.getInputStream());
				while(bConnected)
				{
					String str = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
