package simpleNetTest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		ServerSocket s = null;
		
		try {
			s = new ServerSocket(5432);
		} catch (IOException e) {
			e.printStackTrace();
		}
		while(true){
			try {
				Socket s1 = s.accept();
				OutputStream s1out = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(s1out);
				dos.writeUTF("Server say:Hello World!");
				s1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
