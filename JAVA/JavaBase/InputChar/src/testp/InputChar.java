package testp;
import java.io.*;

public class InputChar {
	public static String str1 = "javaString!";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = ' ';
		try
		{
			c = (char)System.in.read();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		System.out.println("You've entered a character:"+c);
	}

}
