package com.tc.designPattern._02FactoryParttern.case3;

public class Singleton {
    // 不允许通过new产生一个对象
    private Singleton() { }
    public void doSomething() {
        // 业务处理
        System.out.println("====doSomething====");
    }
}
