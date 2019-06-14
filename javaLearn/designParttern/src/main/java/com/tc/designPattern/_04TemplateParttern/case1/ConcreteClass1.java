package com.tc.designPattern._04TemplateParttern.case1;

public class ConcreteClass1 extends AbatractClass {
    // 实现基本方法
    @Override
    public void doSomething() {
        // 业务逻辑处理
        System.out.println("doSomething 1");
    }

    // 实现基本方法
    @Override
    public void doAnything() {
        // 业务逻辑处理
        System.out.println("doAnything 1");
    }
}
