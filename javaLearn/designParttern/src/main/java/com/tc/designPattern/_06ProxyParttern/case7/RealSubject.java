package com.tc.designPattern._06ProxyParttern.case7;

/**
 * 真实主题
 */
public class RealSubject implements Subject {

    // 业务操作
    @Override
    public void doSomething(String str) {
        System.out.println("do something!---->" + str);
    }
}
