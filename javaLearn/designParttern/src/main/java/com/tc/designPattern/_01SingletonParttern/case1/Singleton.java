package com.tc.designPattern._01SingletonParttern.case1;

/**
 * 懒汉式
 * Author:tangc
 * Date:2016/6/18
 * Time:17:21
 * DESCR:
 */
public class Singleton {
    /**
     * 定义了一个变量来储存创建好的类实例
     */
    private static Singleton uniqueInstance = null;

    /**
     *  私有化构造方法，可以在内部控制创建实例的数目
     */
    private Singleton() {
    }

    public static synchronized Singleton getInstance(){//懒汉式有同步关键字synchronized，饿汉式没有。
        if(null == uniqueInstance){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    /**
     * 示意方法：单例可以有自己的操作
     */
    public void singletonOperation(){
        //功能处理
    }

    /**
     * 示意属性：单例可以有自己的属性
     */
    private Object singleData;

    public Object getSingleData() {
        return singleData;
    }

    public void setSingleData(Object singleData) {
        this.singleData = singleData;
    }
}
