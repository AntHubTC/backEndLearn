package stream.zip;

import java.io.*;
import java.util.Calendar;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by tangc on 2016/2/18.
 */
public class zipTest {
    public static void main(String[] args){
        try {
            File file = new File("test.zip");
            ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file));
//            JarInputStream
//            JarOutputStream
//            JarEntry
//            zos.putNextEntry(new ZipEntry("项"));//添加一项新内容
            ZipEntry zipEntry;
//            ZipFile zipFile = new ZipFile("test.zip");
            while ((zipEntry = zis.getNextEntry())!=null){
                String entryName = zipEntry.getName();
                long entrySize = zipEntry.getSize();
                System.out.println("fileName:"+entryName
                        +"   entrySize:"+ entrySize
                        +"   isDirectory:"+zipEntry.isDirectory());
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(zipEntry.getTime());
                System.out.println(calendar.getTime());
                zis.closeEntry();
            }
            zis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
