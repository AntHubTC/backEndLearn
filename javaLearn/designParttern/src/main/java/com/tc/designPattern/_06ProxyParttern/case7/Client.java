package com.tc.designPattern._06ProxyParttern.case7;

import java.lang.reflect.InvocationHandler;

public class Client {
    public static void main(String[] args) {
        // 定义一个主题
        Subject subject = new RealSubject();
        Class clzss = subject.getClass();
        ClassLoader classLoader = clzss.getClassLoader();
        // 定义一个Handler
        InvocationHandler handler = new MyInvocationHandler(subject);
        // 定义主题的代理
        Subject proxy = DynamicProxy.<Subject>newProxyInstance(classLoader, clzss.getInterfaces(), handler);
        // 代理的行为
        proxy.doSomething("study!~");
        proxy.doSomething("work!~");
    }
}
