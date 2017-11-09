import java.net.Socket;
import java.net.ServerSocket;
import java.io.*;
class AcceptTcp
{
	public static void main(String[] args)
	{
		if(args.length!=1)
		{
			System.out.println("Your input is Wrong!Try again!");
			System.exit(0);
		}
		try
		{
			ServerSocket socketObj = new ServerSocket(Integer.parseInt(args[0]));
			while(true) {
				Socket s = socketObj.accept();
				System.out.println("a client connect!");
				DataInputStream dis = new DataInputStream(s.getInputStream());
				System.out.println(dis.readUTF());
				dis.close();
				s.close();
			}


		}
		catch(IOException e)
		{
			System.out.print(e);
		}
		
	}
}