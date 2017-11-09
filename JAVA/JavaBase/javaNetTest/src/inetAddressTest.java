import java.net.*;

public class inetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("localhost");
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			
			ia = null;
			
			ia = InetAddress.getLocalHost();
			System.out.println(ia.getHostName());//???
			System.out.println(ia.getHostAddress());
			
			System.out.println("InetAddress(IP) count:" + InetAddress.getAllByName("boringman").length);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
