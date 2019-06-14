package simpleNetTest;

import java.net.*;
import java.io.*;

public class Client {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",5432);
			InputStream sIn = s.getInputStream();
			DataInputStream dis = new DataInputStream(sIn);
			String message = dis.readUTF();
			System.out.println(message);
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
