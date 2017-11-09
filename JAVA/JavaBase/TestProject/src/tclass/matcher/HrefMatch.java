package tclass.matcher;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tangc on 2016/2/19.
 */
public class HrefMatch {
    public static void main(String[] args){
        //get URL string from command  line or use default
        try {
            String urlString;
            Scanner in = new Scanner(System.in);
            urlString = in.nextLine();

            //Open reader for URL
            InputStreamReader isr = new InputStreamReader(new URL(urlString).openStream());

            //read contents into string builder
            StringBuilder builder = new StringBuilder();
            int ch;
            System.out.println("开始读取网页");
            while((ch = isr.read()) != -1){
                builder.append((char)ch);
            }
            System.out.println("网页读取完毕！");
            System.out.println("网页正文：");
            System.out.println(builder.toString());
            //search for all occurrences of pattern
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(builder);

            System.out.println("开始执行匹配");
            while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                String match = builder.substring(start, end);
                System.out.println(match);
            }
            System.out.println("Program end!");
            isr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
