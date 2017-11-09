package UDPSendTest;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSend {
	public static final String usage = "�÷���java UDPSend<hostname><port><msg>...\n" +
			"��java UDPSend<hostname><port>-f<file>";
	public static void main(String[] args) {
		try{
			if(args.length < 3)
			{
				throw new Exception("��������");
			}
			String host = args[0];
			int port = Integer.parseInt(args[1]);
			byte[] message;
			if(args[2].equals("-f")){
				File f = new File(args[3]);
				int len = (int)f.length();
				message = new byte[len];
				FileInputStream in = new FileInputStream(f);
				int bytes_read = 0;
				in.read(message, bytes_read, len);
			} else {
				String msg = args[2];
				for(int i=3; i<args.length; i++){
					msg += "" + args[i];
				}
				message = msg.getBytes();
			}
			InetAddress address = InetAddress.getByName(host);
			DatagramPacket packet = new DatagramPacket(message, message.length, address, port);
			DatagramSocket dsocket = new DatagramSocket();
			dsocket.send(packet);
			dsocket.close();
		} catch (Exception e){
			System.err.println(e.getMessage());
			System.err.println(usage);
			//err��out��֮ͬ����err�������out��ǰ�棬������eclipse�����ɫΪ��ɫ,out������Ǻ�ɫ
		}
	}

}
