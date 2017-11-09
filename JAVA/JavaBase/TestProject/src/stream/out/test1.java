package stream.out;

import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by tangc on 2016/2/18.
 */
public class test1 {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("各位父老乡亲，大家好！");
        pw.close();
    }
}
