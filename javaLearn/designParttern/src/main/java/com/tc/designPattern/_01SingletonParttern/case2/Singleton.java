package com.tc.designPattern._01SingletonParttern.case2;

/**
 * 饿汉式
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

    static {
        uniqueInstance = new Singleton();
    }

    /**
     *  私有化构造方法，可以在内部控制创建实例的数目
     */
    private Singleton() {
    }

    public static Singleton getInstance(){
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
