package com.tc.designPattern._06ProxyParttern.case5;

// 强制代理模式
public class Client {

    public static void main(String[] args) {
        IGamePlayer gamePlayer = new GamePlayer("zhangsan");
        IGamePlayer proxy = gamePlayer.getProxy();
        System.out.println("==========================");
        proxy.login("zhangsan", "123456");
        proxy.killBoss();
        proxy.upgrade();
        proxy.killBoss();
        proxy.upgrade();
        proxy.killBoss();
        proxy.upgrade();

        System.out.println("==========================");
        System.out.println("代理者个性输出：：");
        IProxy proxyInter = (IProxy) proxy;
        proxyInter.outTotalAmount();
        System.out.println("==========================");
    }
}
