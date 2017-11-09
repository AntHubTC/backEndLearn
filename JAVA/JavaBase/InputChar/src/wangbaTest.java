import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class wangbaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame();
		f.setSize(500,400);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		wangba t = new wangba();
		f.add(t);
		f.show();
	}

}

class wangba extends Panel
{
	public void paint(Graphics g)
	{
		g.setColor(new Color(40,40,10));
		g.fillOval(20, 70, 50, 50);//左上
		g.fillOval(150, 70, 50, 50);//右上
		g.fillOval(20, 240, 50, 50);//左下
		g.fillOval(150, 240, 50, 50);//右下
		g.fillOval(85, 10, 50, 60);//头
		g.setColor(Color.WHITE);
		g.fillOval(90, 15, 15, 20);//eye
		g.fillOval(115, 15, 15, 20);//eye
		g.setColor(Color.BLACK);
		g.fillOval(90, 15, 10, 15);//eye
		g.fillOval(115, 15, 10, 15);//eye
		g.setColor(new Color(0,30,0));
		g.fillOval(30, 50, 160, 250);//body
		g.setColor(new Color(0,50,0));
		g.fillOval(40,60, 140, 230);//body
		g.setColor(Color.BLACK);
		g.drawLine(65,85,90,120);
	}
}