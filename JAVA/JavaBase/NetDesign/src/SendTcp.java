import java.net.Socket;
import java.io.*;
class SendTcp
{
	public static void main(String[] args)
	{
		if(args.length<4)
		{
			System.out.println("Your input is Wrong!Try again!");
			System.exit(0);
		}
		try
		{
			String str;
			if(args.length<=4)
			{
				str = new String("This is a Tcp packet from source host to destination host");
			}
			else
			{
				str = new String(args[4]);
			}
			
			Socket socketObj = new Socket(args[2],Integer.parseInt(args[3]));
			OutputStream os = socketObj.getOutputStream();
			//OutputStreamWriter osw = new OutputStreamWriter(os);
			DataOutputStream osw = new DataOutputStream(os);
			osw.writeUTF(str);
			osw.flush();
			socketObj.close();
			System.out.print("Send OK!");
		}
		catch(IOException e)
		{
			System.out.println("Sorry,can't connect to "+args[0]+":"+args[3]);
			System.out.print(e);
		}
		
	}
}