import sun.audio.*;
import java.io.*;

public class playSound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fileau;
		
		try {
			File f = new File("GAve.wav");
			fileau = new FileInputStream(f);//²»Ö§³Ömp[3
			AudioStream as;
			as = new AudioStream(fileau);
			AudioPlayer.player.start(as);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
