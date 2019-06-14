package com.tc.designPattern._06ProxyParttern.case4;

// 强制代理的真实角色
public interface IGamePlayer {
    // 登录游戏
    public void login(String user,String password);
    // 杀怪，这是网络游戏的主要特色
    public void killBoss();
    // 升级
    public void upgrade();
    // 每个人都可以找一下自己的代理
    public IGamePlayer getProxy();
}
