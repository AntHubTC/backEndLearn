package com.tc.designPattern._06ProxyParttern.case5;

// 强制代理的代理类
public class GamePlayerProxy implements IGamePlayer, IProxy {

    private IGamePlayer gamePlayer = null;

    private Integer upgradeCount = 0; // 为玩家升级的

    // 构造函数传递用户名
    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    // 代练杀怪
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    // 代练登录
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    // 代练升级
    public void upgrade() {
        this.gamePlayer.upgrade();
        // 玩家升级后记录一次升级次数
        this.count();
    }

    // 代理的代理暂时还没有，就是自己
    public IGamePlayer getProxy() {
        return this;
    }

    @Override
    public void count() {
        upgradeCount++;
    }

    @Override
    public void outTotalAmount() {
        // 为玩家升一级50块钱
        Integer amount = upgradeCount * 50;
        System.out.println("总共为玩家升级了" + upgradeCount + "级");
        System.out.println("总共需要收取玩家费用:" + amount + ".00元(20元/级)");
    }
}
