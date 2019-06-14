import java.io.*;

public class FileReadTest {
	private static File file;
	private static FileInputStream fis;
	public static void main(String[] args){
		file = new File("fileReadTest.txt");
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			while(dis.available() != 0){
				System.out.print((char)dis.read());//ASCII²»ÄÜ¶ÁÈëºº×Ö//dis.readUTF();
			}
			System.out.print(dis.readUTF());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
