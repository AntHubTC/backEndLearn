package com.tc.designPattern.Adapter.case1;

/**
 * 已经存在的接口，这个接口需要适配
 * Author:tangc
 * Date:2016/6/18
 * Time:16:53
 * DESCR:
 */
public class Adaptee {
    /**
     * 示意方法，原本已经存在，已经实现的方法
     */
    public void specificRequest(){
        //具体的功能处理
        System.out.println("Adaptee>>specificRequest()");
    }
}
