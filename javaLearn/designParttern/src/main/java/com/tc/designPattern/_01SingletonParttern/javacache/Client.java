package com.tc.designPattern._01SingletonParttern.javacache;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:18:01
 * DESCR:
 */
public class Client {
    public static void main(String args[]){
        JavaCache instance = JavaCache.getInstance();
        String value = (String)instance.getValue("2");
        System.out.println(value);
        value = (String)instance.getValue("2");
        System.out.println(value);
    }
}
