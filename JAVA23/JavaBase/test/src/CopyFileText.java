import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class CopyFileText {
	private static File file1;
	private static File file2;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	
	/*
	技巧1：Ctrl+/ 快速注释本行或选择的行(单行注释//)
	技巧2：Ctrl+?(即Ctrl+shift+/) 快速注释本行或选择的行(多行注释/*  *\/)
	*/
	
	public static void main(String[] args) {
//		file1 = new File("1.txt");
//		file2 = new File("2.txt");
		file1 = new File("src.zip");
		file2 = new File("2.zip");
		
		if(!file1.exists())
		{
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			
//			while(fis.available() != 0)
//			{
//				char ch;
//				fos.write(ch=(char)fis.read());
//				System.out.print(ch);
//			}
			byte[] tmp = new byte[9216];//建议使用2的n方
			int size = 0;
			while(fis.available() != 0)
			{
				fis.read(tmp);
				fos.write(tmp);
			}
//			size=fis.read(tmp);
//			fos.write(tmp,0,size);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("OK!");
	}

}
