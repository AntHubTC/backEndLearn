import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	private List<int[]> pos= new ArrayList<int[]>();
	
	private boolean isRun = true;
	
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
		
		int[] temp = new int[2];
		temp[0] = minx = bi.getMinX();
		temp[1] = miny = bi.getMinY();
		pos.add(temp);
//		temp[0] = width/2;
//		temp[1] = height/2;
//		pos.add(temp);
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
		for(int i=0; i<pos.size(); i++)
		{
			gT.setColor(new Color(rgb1[0], rgb1[1], rgb1[2]));
			gT.drawRect(pos.get(i)[0], pos.get(i)[1], 3, 3);
		}
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(biT, 0, 0, null);
	}
	
	@Override
	public void run() {
		while(isRun){
			for(int i=0; i<pos.size(); i++){
				if(pos.get(i)[1]<height-1){
					pos.get(i)[1]++;
				}
				else if(pos.get(i)[0]+1<width-1){
					pos.get(i)[0]++;
					if(pos.get(i)[0]<width-1){
						pos.get(i)[1] = miny;
					}
				}
				else
				{
					isRun = false;
					return;
				}
				
				int pixel = bi.getRGB(pos.get(i)[0], pos.get(i)[1]);
				rgb1[0] = (pixel & 0xff0000) >> 16;
				rgb1[1] = (pixel & 0x00ff00) >> 8;
				rgb1[2] = (pixel & 0x0000ff);
				
				System.out.println("i=" + pos.get(i)[0] + ",j=" + pos.get(i)[1] + "    RGB:(" + rgb1[0]
						+ "," + rgb1[1] + "," + rgb1[2] + ")");
			}
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

}
