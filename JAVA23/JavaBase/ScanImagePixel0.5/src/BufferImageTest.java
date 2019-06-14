import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

//ЫЋЛ­
public class BufferImageTest extends Frame implements Runnable {

	private static int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private int minx;
	private int miny;
	private int imgHeight;
	private int imgWidth;

	private BufferedImage bi;
	private BufferedImage biT;
	private Graphics gT;
	private File file;

	private List<float[]> position = new ArrayList<float[]>();
	private List<float[]> posStop = new ArrayList<float[]>();

	private List<int[]> rgb = new ArrayList<int[]>();

	private static int COUNT = 10;
	
	private boolean isRun = true;

	public BufferImageTest() {
		file = new File(BufferImageTest.class.getClassLoader().getResource("images/44444.jpg").getPath());
				//.getResource("images/20.jpg").getPath());
				
		bi = null;
		try {
			bi = ImageIO.read(file);
			biT = new BufferedImage(bi.getWidth(), bi.getHeight(),
					BufferedImage.TYPE_INT_RGB);
			gT = biT.getGraphics();
		} catch (IOException e) {
			e.printStackTrace();
		}

		imgWidth = bi.getWidth();
		imgHeight = bi.getHeight();

		for(int i=0; i<COUNT; i++){
			float[] temp = new float[2];
			if(0 != i){
				temp[0] = (int) (imgWidth * i*1.0/COUNT);
				temp[1] = 0;
			}
			else
			{
				temp[0] = minx = bi.getMinX();
				temp[1] = miny = bi.getMinY();
			}
			posStop.add(new float[]{(imgWidth * (i+1)*1.0f/COUNT)-1,imgHeight});
			position.add(temp);
		}
		System.out.println(position.get(0)[0]);
		System.out.println("W:" + imgWidth + "H:" + imgHeight);
		System.out.println("MX:" + minx + "MY:" + miny);

		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}

	public void draw() {
		for (int i = 0; i < position.size(); i++) {
			gT.setColor(new Color(rgb.get(rgb.size()-COUNT+i)[0], rgb.get(rgb.size()-COUNT+i)[1], rgb.get(rgb.size()-COUNT+i)[2]));
			gT.fillRect((int)position.get(i)[0], (int)position.get(i)[1], 3, 3);
//			System.out.println(i + "" + pos.get(i)[0]);
		}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(biT, 0, 0,SCREEN_WIDTH, SCREEN_HEIGHT, null);
	}

	public int getProcess() {
		return (int) position.get(0)[0];
	}

	@Override
	public void run() {
		while (isRun) {
			for (int i = 0; i < position.size(); i++) {

				String title = "е§дк" + getProcess() + "%";
				this.setTitle(title);
	
				if (position.get(i)[1] < imgHeight-3) {
					position.get(i)[1] += 3;
				} else if (position.get(i)[0] < imgWidth-31) {
					position.get(i)[0] += 3;
					position.get(i)[1] = miny;
				} else {
					position.get(i)[0] += 0;
					position.get(i)[1] = miny;
				}
				if (position.get(1)[1] > posStop.get(1)[1]){
					return;
				}
				int pixel = bi.getRGB((int)position.get(i)[0], (int)position.get(i)[1]);
				int[] rgbT = new int[3];
				rgbT[0] = (pixel & 0xff0000) >> 16;
				rgbT[1] = (pixel & 0x00ff00) >> 8;
				rgbT[2] = (pixel & 0x0000ff);
				rgb.add(rgbT);

//				 System.out.println("i=" + position.get(i)[0] + ",j=" +
//				 position.get(i)[1]
//				 + "    RGB:(" + rgbT[0] + "," + rgbT[1] + "," + rgbT[2]
//				 + ")");
			}// end for
			
			try {
				draw();
				Thread.sleep(5);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}// end while
	}// end run
}// end class
