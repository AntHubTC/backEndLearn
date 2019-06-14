import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Ë«»­
public class BufferImageTest extends Frame implements Runnable {
	int[] rgb1 = new int[3];
	int[] rgb2 = new int[3];
	private int minx;
	private int miny;
	private int height;
	private int width;
	private BufferedImage bi;
	private BufferedImage biT;
	private Graphics gT;
	private File file;
	private int i1,j1;
	private int i2,j2;
	public static void main(String[] args) {
		BufferImageTest bIT = new BufferImageTest();
		Thread t = new Thread(bIT);
		t.start();
	}
	
	public BufferImageTest() {
		file = new File(BufferImageTest.class.getClassLoader().getResource("images/20.jpg").getPath());
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
		i1 = minx = bi.getMinX();
		j1 = miny = bi.getMinY();
		i2 = width/2;
		j2 = height/2;
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
	public void update(Graphics g) {
		gT = biT.getGraphics();
		gT.setColor(new Color(rgb1[0], rgb1[1], rgb1[2]));
		gT.drawRect(i1, j1, 3, 3);
		gT.setColor(new Color(rgb2[0], rgb2[1], rgb2[2]));
		gT.drawRect(i2, j2, 3, 3);
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
//		for (int i = minx; i < width; i++)
//			for (int j = miny; j < height; j++) {
//				int pixel = bi.getRGB(i, j);
//				rgb[0] = (pixel & 0xff0000) >> 16;
//				rgb[1] = (pixel & 0x00ff00) >> 8;
//				rgb[2] = (pixel & 0x0000ff);
				g.drawImage(biT, 0, 0, null);
//			}
	}

//	public void paint(Graphics g){
//		g.drawImage(biT, 0, 0, null);
//	}
	@Override
	public void run() {
		while(true){
			if(j1+1<height){
				j1++;
			}
			else if(i1+1<width){
				i1++;
				if(i1<width){
					j1 = miny;
				}
			}
			else
			{
				break;
			}
			if(j2+1<height){
				j2++;
			}
			else if(i2+1<width){
				i2++;
				if(i2<width){
					j2 = miny;
				}
			}
			else
			{
				break;
			}
			
			
//			if(j1+2<height){
//				j1+=2;
//			}
//			else if(i1+2<width){
//				i1+=2;
//				if(i1<width){
//					j1 = miny;
//				}
//			}
//			else
//			{
//				break;
//			}
//			
//			if(j2+2<height){
//				j2+=2;
//			}
//			else if(i2+2<width){
//				i2+=2;
//				if(i2<width){
//					j2 = miny;
//				}
//			}
//			else
//			{
//				break;
//			}
			
			int pixel = bi.getRGB(i1, j1);
			rgb1[0] = (pixel & 0xff0000) >> 16;
			rgb1[1] = (pixel & 0x00ff00) >> 8;
			rgb1[2] = (pixel & 0x0000ff);
			pixel = bi.getRGB(i2, j2);
			rgb2[0] = (pixel & 0xff0000) >> 16;
			rgb2[1] = (pixel & 0x00ff00) >> 8;
			rgb2[2] = (pixel & 0x0000ff);
			System.out.println("i=" + i1 + ",j=" + j1 + "    RGB:(" + rgb1[0]
					+ "," + rgb1[1] + "," + rgb1[2] + ")");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

}
