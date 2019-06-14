package com.tc.designPattern._01SingletonParttern.javacache;

import java.util.HashMap;
import java.util.Map;

/**
 * Java中缓存的基本实现示例
 * Author:tangc
 * Date:2016/6/18
 * Time:17:52
 * DESCR:
 */
public class JavaCache {
    /**
     * 缓存数据的容器，定义成Map是方便访问，直接根据key就可以获取value了，
     * key选用String是为了简单，方便演示。
     */
    private static Map<String, Object> map = new HashMap<String, Object>();
    private static JavaCache javaCache = new JavaCache();
    private JavaCache(){
    }
    public static JavaCache getInstance(){
        return javaCache;
    }

    /**
     *  从缓存中获取值
     * @param key 设置时候的key
     * @return key对应的Value值
     */
    public Object getValue(String key){
        //先从缓存里面取值
        Object obj = map.get(key);
        //判断缓存里面是否有值
        if(null == obj){
            //如果没有值就从另一个地方取出来设置进去，以备下次使用。
            obj = key + ",value";
            map.put(key, obj);
            System.out.println("我从其他地方取到了key=" + key + "的值");
        } else {
            System.out.println("我从cache中取到了key=" + key + "的值");
        }
        //如果有值了，就直接返回使用
        return obj;
    }
}
