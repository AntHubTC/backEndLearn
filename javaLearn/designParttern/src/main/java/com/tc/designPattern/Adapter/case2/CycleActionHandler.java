package com.tc.designPattern.Adapter.case2;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:17:14
 * DESCR:
 */
public class CycleActionHandler extends ActionAdapter {

    @Override
    public void click() {
        super.click();
        System.out.println("你单击了圆.");
    }
}
