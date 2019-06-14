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
	����1��Ctrl+/ ����ע�ͱ��л�ѡ�����(����ע��//)
	����2��Ctrl+?(��Ctrl+shift+/) ����ע�ͱ��л�ѡ�����(����ע��/*  *\/)
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
			byte[] tmp = new byte[9216];//����ʹ��2��n��
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
