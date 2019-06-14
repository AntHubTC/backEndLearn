package com.tc.designPattern._10ChainParttern.case1;

// 丈夫
public class Husband implements IHandler {
    // 妻子向丈夫请示
    @Override
    public void HandleMessage(IWomen women) {
        System.out.println("妻子的请示是："+women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }
}
