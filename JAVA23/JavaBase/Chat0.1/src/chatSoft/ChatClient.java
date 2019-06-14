package chatSoft;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*****
 * 
 * 实现了基本的窗口
 *
 */

public class ChatClient extends Frame{
	
	public void launchFrame()
	{
		this.setLocation(400,300);
		this.setSize(300,300);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

}
