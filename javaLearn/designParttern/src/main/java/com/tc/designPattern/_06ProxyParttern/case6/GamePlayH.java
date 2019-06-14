package com.tc.designPattern._06ProxyParttern.case6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 动态代理类
public class GamePlayH implements InvocationHandler { // InvocationHandler是JDK提供的动态代理接口。
    // 被代理者
    Class cls = null;
    // 被代理的实例
    Object obj = null;

    // 我要代理谁
    public GamePlayH(Object obj) {
        this.obj = obj;
    }

    // 调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果是登录方法，则发送信息
        if(method.getName().equalsIgnoreCase("login")){
            System.out.println("有人在用我的账号登录！");
        }
        Object result = method.invoke(this.obj, args);
        return result;
    }
}
