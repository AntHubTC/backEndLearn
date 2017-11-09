package stream.fileStream;

import java.io.*;
import java.nio.channels.FileChannel;

public class test1 {
    public static void main(String[] args){
        try {
            FileOutputStream fos = new FileOutputStream("test.data");
            FileChannel channel = fos.getChannel();
            FileDescriptor descriptor = fos.getFD();
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            PrintWriter pw = new PrintWriter(fos);
            pw.print("努力奋斗，勇往直前！");
            pw.close();

            FileInputStream fis = new FileInputStream("test.data");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            System.out.println(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
