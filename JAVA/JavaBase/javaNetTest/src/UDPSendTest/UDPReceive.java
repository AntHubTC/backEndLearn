package UDPSendTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceive {

	public static final String usage = "用法：java UDPReceive<port>";

	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new IllegalArgumentException("参数个数不对");
			}
			int port = Integer.parseInt(args[0]);
			DatagramSocket dsocket = new DatagramSocket(port);
			byte[] buffer = new byte[2048];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			while (true) {
				dsocket.receive(packet);
				String msg = new String(buffer, 0, packet.getLength());
				System.out.println(packet.getAddress().getHostName() + ":" + msg);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println(usage);
		}
	}
}
