package Singleton.case8;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单演示如何扩展单例模式，控制实例数目为3个
 * 该方式是线程不安全的，如果需要线程安全，那么需要进一步进行处理。
 * Author:tangc
 * Date:2016/7/12
 * Time:20:53
 * DESCR:
 */
public class OneExtend {
    /**
     * 定义一个缺省的key值的前缀
     */
    private final static String DEFAULT_PREKEY = "Cache";

    /**
     * 缓存实例的容器
     */
    private static Map<String, OneExtend> map = new HashMap<String, OneExtend>();

    /**
     * 用来记录当前正在使用的第几个实例，到了控制的最大数目，就返回从1开始
     */
    private static int num = 1;

    /**
     * 定义控制实例的最大数目
     */
    private final static int NUM_MAX = 3;

    private OneExtend(){}

    public static OneExtend getInstance(){
        String key = DEFAULT_PREKEY + num;
        OneExtend oneExtend = map.get(key);
        if(null == oneExtend){
            oneExtend = new OneExtend();
            map.put(key, oneExtend);
        }
        //把当前实例的序号加1
        num++;
        if(num > NUM_MAX){
            //如果实例的序号已经达到最大数目了，那就重复从1开始获取
            num = 1;
        }
        return oneExtend;
    }
}
