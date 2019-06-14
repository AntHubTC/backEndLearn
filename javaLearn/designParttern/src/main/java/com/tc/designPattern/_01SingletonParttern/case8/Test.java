package com.tc.designPattern._01SingletonParttern.case8;

/**
 * Author:tangc
 * Date:2016/7/13
 * Time:16:14
 * DESCR:
 */
public class Test {
    public static void  main(String args[]){
        OneExtend t1 = OneExtend.getInstance();
        OneExtend t2 = OneExtend.getInstance();
        OneExtend t3 = OneExtend.getInstance();
        OneExtend t4 = OneExtend.getInstance();
        OneExtend t5 = OneExtend.getInstance();
        OneExtend t6 = OneExtend.getInstance();

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);

        System.out.println(t4);
        System.out.println(t5);
        System.out.println(t6);
    }
}
