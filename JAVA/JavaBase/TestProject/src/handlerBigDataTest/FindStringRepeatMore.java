package handlerBigDataTest;

import java.io.*;
import java.util.*;

/**
 * 在500万字符串中找到出现次数最多的20个串，它没说串的平均长度，我们假设内存装的下吧
 *
 * 思路：
 * 第一个用hash来做，将500万字符串一条一条的读入，然后将字符串放入hash中，串做为key，
 * 出现次数作为value，不存在直接放入，存在value+1，将数据加入完之后，然后遍历hash，
 * 读入的节点找到value然后将这个<key,value>放入一个二叉树，这个二叉树只能加20个节点，
 * 小的放左边大的放右边，超过二十个节点替换最小的然后调整树，直到完毕，最后得到的
 * 就是出现最多的20个串。
 * Created by tangc on 2016/3/2.
 */
public class FindStringRepeatMore {
    public static void main(String[] args) throws Exception{
        File strFile = new File("moreStr.txt");
        //制造一个500万的字符串
//        makeString(strFile, 5000000);
        int num = 10;
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            //找到出现次数最多的20个串
            List<Map.Entry<String, Integer>> timesMore = findTimesMore(strFile, 20);
            System.out.println("它们分别是：");
            for (Map.Entry<String, Integer> stringIntegerMap : timesMore) {
                System.out.println(stringIntegerMap.getKey()+"出现"+stringIntegerMap.getValue()+"次");
            }
            System.out.println("-----------------------------");
        }
        long end = System.currentTimeMillis();
        System.out.println("总共耗时"+((end-start)/(num*1.0))+"毫秒");
    }

    public static void makeString(File file,Integer num) throws IOException {
        FileOutputStream fos = new FileOutputStream(file,false);
        PrintWriter pw = new PrintWriter(fos);
        while (num > 0){
            num --;
            pw.println((int)(Math.random()*10000));
        }
        pw.close();
        fos.close();
    }

    public static List<Map.Entry<String,Integer>> findTimesMore(File file,Integer num) throws IOException {
        HashMap<String,Integer> container = new HashMap<String, Integer>();
        List<Map.Entry<String,Integer>> resultList = new ArrayList<Map.Entry<String, Integer>>();
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String str;
        while((str = br.readLine()) != null){
            if(null == container.get(str)){
                container.put(str,1);
            } else {
                container.put(str,container.get(str)+1);
            }
        }
        for (Map.Entry<String, Integer> entry : container.entrySet()) {
            if(resultList.size() < num){
                resultList.add(entry);
            } else {
                Map.Entry<String, Integer> minEntry = null;
                for (Map.Entry<String, Integer> temp : resultList) {
                    if(minEntry == null){
                        minEntry = temp;
                    } else if(minEntry.getValue() > temp.getValue()){
                        minEntry = temp;
                    }
                }
                if (minEntry != null){
                    if (minEntry.getValue() < entry.getValue()){
                        resultList.remove(minEntry);
                        resultList.add(entry);
                    }
                }
            }
        }
        return resultList;
    }
}
