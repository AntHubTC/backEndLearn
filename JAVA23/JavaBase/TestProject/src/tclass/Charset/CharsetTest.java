package tclass.Charset;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by tangc on 2016/2/18.
 */
public class CharsetTest {
    public static void main(String[] args){
        Charset charset = Charset.forName("utf-8");
        Set<String> aliases = charset.aliases();//获取所有别名
        System.out.println("aliase:");
        for (String aliase : aliases) {
            System.out.println(aliase);
        }

        System.out.println("availableCharsets:");//所有可利用的字符集
        SortedMap<String, Charset> stringCharsetSortedMap = charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        Charset charset1 = Charset.defaultCharset();
        System.out.println("defaultCharset:"+charset);
        //转码
        charset = Charset.forName("UTF-16");
        String str = "各位父老乡亲，大家好！";
        ByteBuffer buffer = charset.encode(str);
        byte[] bytes = buffer.array();
        System.out.println(new String(bytes));
        System.out.println(charset.decode(buffer));



    }
}
