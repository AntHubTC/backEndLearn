package tclass.Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new InputStreamReader(new FileInputStream("test.properties"),"utf-8"));
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key+"="+properties.get(key));
        }
        FileOutputStream outputStream = new FileOutputStream("test.xml");
        properties.storeToXML(outputStream,"comment");
        outputStream.close();
    }
}
