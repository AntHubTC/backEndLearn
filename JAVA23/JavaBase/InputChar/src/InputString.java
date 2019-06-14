import java.io.*;
import testp.InputChar;

public class InputString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(InputChar.str1);
		String str = "";
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			str = in.readLine();
		}
		catch(IOException e)
		{
		
		}
		System.out.println(str);
		
	}

}
