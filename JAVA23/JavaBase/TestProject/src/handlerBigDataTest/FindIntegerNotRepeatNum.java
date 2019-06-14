package handlerBigDataTest;

import java.io.*;
import java.util.Scanner;

/**
 * Created by tangc on 2016/3/2.
 * 2亿个整数中统计不重复的个数
 */
public class FindIntegerNotRepeatNum {
    public static void main(String[] args) throws Exception{
        File strFile = new File("nums.txt");
        //制造2亿个整数
//        makeInteger(strFile, 5000000);
        long start = System.currentTimeMillis();
        Long num = FindNotRepeatNum(strFile);
        System.out.println("num:"+num);
        long end = System.currentTimeMillis();
        System.out.println("总共耗时"+((end-start)/(num*1.0))+"毫秒");
    }

    public static void makeInteger(File file,Integer num) throws IOException {
        FileOutputStream fos = new FileOutputStream(file,false);
        PrintWriter pw = new PrintWriter(fos);
        while (num > 0){
            num --;
            pw.write((int)(Math.random()*10000));
        }
        pw.close();
        fos.close();
    }

    public static Long FindNotRepeatNum(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        Scanner scanner = new Scanner(br);
        while (scanner.hasNextInt()){
            int intNum = scanner.nextInt();
            System.out.println(intNum);
        }
        scanner.close();
        br.close();
        fis.close();
        return 2l;
    }
}
