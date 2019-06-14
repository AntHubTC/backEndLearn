package com.tc.designPattern._01SingletonParttern.case3;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:17:36
 * DESCR:
 */
public class Client {
    public static void main(String args[]){
        AppConfig appConfig = AppConfig.getInstance();
        System.out.println(appConfig.getParamA());
        System.out.println(appConfig.getParamB());
    }
}
