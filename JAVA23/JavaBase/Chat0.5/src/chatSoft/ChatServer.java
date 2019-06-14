package chatSoft;

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
System.out.print("a clent connected");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
