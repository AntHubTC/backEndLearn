package com.tc.designPattern._06ProxyParttern.case1;

// 代理类
public class Proxy implements Subject { // 代理类实现了抽象主题类接口
    // 要代理哪个实现类
    private Subject subject = null;

    // 默认被代理者
    public Proxy() {
        this.subject = new RealSubject();
    }

    // 通过构造参数传入被代理者
    public Proxy(Object...objects) {
    }

    // 实现接口中定义的方法
    @Override
    public void request() {
        this.before(); // 前处理
        this.subject.request();
        this.after(); // 后处理
    }

    // 预处理
    private void before() {
        // do something
    }

    // 善后处理
    private void after() {
        // do something
    }
}
