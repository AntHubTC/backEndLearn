package chatSoft;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(8888);//8888TCPµÄ¶Ë¿ÚºÅ
			while(true)
			{
				Socket s = ss.accept();
System.out.println("a clent connected");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
				dis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
