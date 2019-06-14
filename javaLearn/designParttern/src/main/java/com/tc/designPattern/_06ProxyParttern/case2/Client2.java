package com.tc.designPattern._06ProxyParttern.case2;

public class Client2 {
    public static void main(String[] args) {
        IGamePlayer zhangsanPlayer = new GamePlayer("张三");
        IGamePlayer playerProxy = new GamePlayerProxy(zhangsanPlayer);
        //开始打游戏，记下时间戳
        System.out.println("开始时间是：2009-8-25 10:45");
        playerProxy.login("zhangSan", "password");
        //开始杀怪
        playerProxy.killBoss();
        //升级
        playerProxy.upgrade();
        //记录结束游戏时间
        System.out.println("结束时间是：2009-8-26 03:40");
    }
}
