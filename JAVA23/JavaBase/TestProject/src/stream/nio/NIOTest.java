package stream.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.CRC32;

public class NIOTest {

    public static long checksumInputStream(String fileName) throws IOException{
        InputStream in = new FileInputStream(fileName);
        CRC32 crc = new CRC32();
        int c;
        while((c = in.read()) != -1){
            crc.update(c);
        }
        return crc.getValue();
    }

    public static long checksumBufferedInputStream(String fileName) throws IOException{
        InputStream in = new BufferedInputStream(new FileInputStream(fileName));
        CRC32 crc = new CRC32();

        int c;
        while((c = in.read()) != -1) crc.update(c);
        return crc.getValue();
    }

    public static long checksumRandomAccessFile(String fileName) throws IOException{
        RandomAccessFile file = new RandomAccessFile(fileName,"r");
        long length = file.length();
        CRC32 crc = new CRC32();

        for (int i = 0; i < length; i++) {
            file.seek(i);
            int c = file.readByte();
            crc.update(c);
        }
        return crc.getValue();
    }

    public static long checksumMappedFile(String fileName) throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        FileChannel channel = in.getChannel();

        CRC32 crc = new CRC32();
        int length = (int) channel.size();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,length);
        for (int i = 0; i < length; i++) {
            int c = buffer.get(i);
            crc.update(c);
        }
        return crc.getValue();
    }

    public static void main(String[] args) throws IOException{
        System.out.println("Input Stream:");
        long start = System.currentTimeMillis();
        long crcValue = checksumInputStream("test.zip");
        long end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start)+"milliseconds");

        System.out.println("Input Stream:");
        start = System.currentTimeMillis();
        crcValue = checksumBufferedInputStream("test.zip");
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start)+"milliseconds");

        System.out.println("Input Stream:");
        start = System.currentTimeMillis();
        crcValue = checksumRandomAccessFile("test.zip");
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start)+"milliseconds");

        System.out.println("Input Stream:");
        start = System.currentTimeMillis();
        crcValue = checksumMappedFile("test.zip");
        end = System.currentTimeMillis();
        System.out.println(Long.toHexString(crcValue));
        System.out.println((end - start)+"milliseconds");
    }
}
