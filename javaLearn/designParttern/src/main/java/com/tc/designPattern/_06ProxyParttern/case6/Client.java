package com.tc.designPattern._06ProxyParttern.case6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

// 神奇的：动态代理
public class Client {
    public static void main(String[] args) {
        // 定义一个痴迷的玩家
        IGamePlayer player = new GamePlayer("张三");
        // 定义一个handler
        InvocationHandler handler = new GamePlayH(player);
        // 获得类的class loader
        ClassLoader cl = player.getClass().getClassLoader();
        // 动态产生一个代理者
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, handler);
        // 登录
        proxy.login("zhangSan", "password");
        // 开始杀怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        /*
                太棒了！有人用我的账号就发送一个信息，然后看看自己的账号是不是被人盗了，非常
            好的方法，这就是AOP编程。AOP编程没有使用什么新的技术，但是它对我们的设计、编码
            有非常大的影响，对于日志、事务、权限等都可以在系统设计阶段不用考虑，而在设计后通
            过AOP的方式切过去。
         */
    }
}
