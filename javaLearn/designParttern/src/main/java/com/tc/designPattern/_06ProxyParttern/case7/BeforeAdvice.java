package com.tc.designPattern._06ProxyParttern.case7;

// 通知接口及实现
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了！");
    }
}
