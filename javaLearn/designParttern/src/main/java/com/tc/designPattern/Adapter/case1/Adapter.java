package com.tc.designPattern.Adapter.case1;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:16:55
 * DESCR:
 */
public class Adapter implements Target {
    /**
     * 持有需要被适配的对象
     */
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        System.out.println("适配请求方法");
        //可能转调已经实现了的方法，进行适配
        adaptee.specificRequest();
    }
}
