package com.tc.designPattern._09CommandParttern.case2;

// 通用Receiver类
public abstract class Receiver {
    // 抽象接收者，定义每个接收者都必须完成的业务
    public abstract void doSomething();
}
