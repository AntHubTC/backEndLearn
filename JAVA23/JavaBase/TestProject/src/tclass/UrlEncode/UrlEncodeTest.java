package tclass.UrlEncode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by tangc on 2016/2/29.
 */
public class UrlEncodeTest {
    public static void main(String[] args){
        try {
            String encodeStr = URLEncoder.encode("[{&quot;name&quot;:&quot;张三&quot;}]", "utf-8");
            System.out.println(encodeStr);
            System.out.println(URLDecoder.decode(encodeStr,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
