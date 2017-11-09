package simpleChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleTalkServer {
	public static int clientnum = 0;
	public static Client [] allclient = new Client[20];

	public static void main(String[] args) {
		try {
			ServerSocket s = new ServerSocket(5432);
			while(true){
				Socket s1 = s.accept();
				DataInputStream din = new DataInputStream(s1.getInputStream());
				DataOutputStream dos = new DataOutputStream(s1.getOutputStream());
				allclient[clientnum] = new Client(clientnum, dos, din);
				allclient[clientnum].start();
				clientnum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class Client extends Thread{
	int id;
	DataOutputStream dos;
	DataInputStream din;
	
	public Client(int id,DataOutputStream dos,DataInputStream din){
		this.id = id;
		this.dos = dos;
		this.din = din;
	}
	
	@Override
	public void run() {
		while(true){
			try{
				String msg = din.readUTF();
				int m = SimpleTalkServer.clientnum;
				for(int i=0; i<m; i++){
					SimpleTalkServer.allclient[i].dos.writeUTF(msg);
				}
			} catch(IOException e){
				SimpleTalkServer.clientnum--;
				//e.printStackTrace();
			}
		}
	}
}
