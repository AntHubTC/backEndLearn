package chatSoft;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.*;

public class ChatServer {

	private static boolean started = false;
	private static boolean bConnected = false;
	
	private static ServerSocket ss = null;
	private static Socket s = null;
	
	private static DataInputStream dis = null;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ss = new ServerSocket(8888);//8888TCPµÄ¶Ë¿ÚºÅ
			started = true;
			while(true)
			{
				s = ss.accept();
System.out.println("a clent connected");
				bConnected = true;
				dis = new DataInputStream(s.getInputStream());
				while(bConnected)
				{
					String str = dis.readUTF();
					System.out.println(str);
				}
				dis.close();
			}
		} 
		catch (EOFException e){
			System.out.println("a client disconnect");
			e.printStackTrace();
		}
		catch (IOException e) {
		} 
		finally
		{
			try {
				if(dis != null) dis.close();
				if(dis != null) ss.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
