package com.tc.designPattern.Adapter.case2;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:17:11
 * DESCR:
 */
public class Client {
    public static void  main(String args[]){
        System.out.println("rect:");
        //未使用适配器的RectActionHandler
        Action rectAction = new RectActionHandler();
        rectAction.click();

        System.out.println();
        System.out.println("cycle:");
        //使用了适配器的CycleActionHandler
        Action cycleAction = new CycleActionHandler();
        cycleAction.click();
    }
}
