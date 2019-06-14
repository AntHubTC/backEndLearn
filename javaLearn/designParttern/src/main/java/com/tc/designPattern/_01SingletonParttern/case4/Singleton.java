package com.tc.designPattern._01SingletonParttern.case4;

import java.util.HashMap;
import java.util.Map;

/**
     利用缓存来实现单例模式
     应用Java缓存的知识，可以变相实现Singleton模式，也算是一个模拟实现吧。每次都先从缓存中取值。只
     要创建一次对象实例后，就设置了缓存的值，那么下次就不用再创建了。
     虽然不是很标准的做法，但是同样可以实现单例模式的功能。为了简单，先不去考虑多线程的问题。
 * Author:tangc
 * Date:2016/6/20
 * Time:8:55
 * DESCR: 使用缓存来模拟实现单例
 */
public class Singleton {
    /**
     * 定义一个key值，用来标识在缓存中的存放
     */
    private final static String DEFAULT_KEY = "One";
    /**
     * 缓存实例的容器
     */
    private static Map<String, Singleton> map = new HashMap<String, Singleton>();
    /**
     * 私有构造方法
     */
    private Singleton() {
    }
    public static Singleton getInstance(){
        //先从缓存中获取
        Singleton instance = (Singleton)map.get(DEFAULT_KEY);
        //如果没有，就新建一个，然后设置回缓存中
        if(null == instance){
            instance = new Singleton();
            map.put(DEFAULT_KEY, instance);
        }
        return instance;
    }
}
