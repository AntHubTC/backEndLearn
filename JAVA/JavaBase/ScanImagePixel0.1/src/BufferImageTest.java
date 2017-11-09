import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BufferImageTest extends Frame implements Runnable {
	int[] rgb = new int[3];
	private int minx;
	private int miny;
	private int height;
	private int width;
	private BufferedImage bi;
	private BufferedImage biT;
	private Graphics gT;
	private File file;
	private int i,j;
	
	public static void main(String[] args) {
		BufferImageTest bIT = new BufferImageTest();
		Thread t = new Thread(bIT);
		t.start();
	}
	
	public BufferImageTest() {
		file = new File(BufferImageTest.class.getClassLoader().getResource("images/8.jpg").getPath());
		bi = null;
		try {
			bi = ImageIO.read(file);
			biT = new BufferedImage(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
//			gT = biT.getGraphics();
		} catch (IOException e) {
			e.printStackTrace();
		}

		width = bi.getWidth();
		height = bi.getHeight();
		i = minx = bi.getMinX();
		j = miny = bi.getMinY();
		System.out.println("W:" + width + "H:" + height);
		System.out.println("MX:" + minx + "MY:" + miny);
		
		this.setSize(800, 600);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}

		});
	}
	

	@Override
	public void paint(Graphics g) {
//		for (int i = minx; i < width; i++)
//			for (int j = miny; j < height; j++) {
//				int pixel = bi.getRGB(i, j);
//				rgb[0] = (pixel & 0xff0000) >> 16;
//				rgb[1] = (pixel & 0x00ff00) >> 8;
//				rgb[2] = (pixel & 0x0000ff);
				gT = biT.getGraphics();
				gT.setColor(new Color(rgb[0], rgb[1], rgb[2]));
				gT.drawRect(i, j, 5, 5);
//				
				g.drawImage(biT, 0, 0, null);
//			}
	}

//	public void paint(Graphics g){
//		g.drawImage(biT, 0, 0, null);
//	}
	@Override
	public void run() {
		while(true){
			if(j+1<height){
				j++;
			}
			else if(i+1<width){
				i++;
				if(i<width){
					j = miny;
				}
			}
			else
			{
				break;
			}
			int pixel = bi.getRGB(i, j);
			rgb[0] = (pixel & 0xff0000) >> 16;
			rgb[1] = (pixel & 0x00ff00) >> 8;
			rgb[2] = (pixel & 0x0000ff);
			System.out.println("i=" + i + ",j=" + j + "    RGB:(" + rgb[0]
					+ "," + rgb[1] + "," + rgb[2] + ")");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

}
