package com.tc.designPattern._06ProxyParttern.case4;

// 强制代理模式
public class Client {
    public static void test1() {
        GamePlayer gamePlayer = new GamePlayer("zhangsan");
        gamePlayer.login("zhangsan", "123456");
        gamePlayer.killBoss();
        gamePlayer.upgrade();
    }

    public static void test2() {
        IGamePlayer gamePlayer = new GamePlayer("zhangsan");
        IGamePlayer proxy = new GamePlayerProxy(gamePlayer);
        proxy.login("zhangsan", "123456");
        proxy.killBoss();
        proxy.upgrade();
    }

    public static void test3() {
        IGamePlayer gamePlayer = new GamePlayer("zhangsan");
        IGamePlayer proxy = gamePlayer.getProxy();
        proxy.login("zhangsan", "123456");
        proxy.killBoss();
        proxy.upgrade();
    }

    public static void main(String[] args) {
        test1();
        System.out.println("===========test1===========");
        test2();
        System.out.println("===========test2===========");
        test3();
        System.out.println("===========test3===========");
    }
}
