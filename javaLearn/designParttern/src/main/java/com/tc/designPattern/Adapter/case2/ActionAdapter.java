package com.tc.designPattern.Adapter.case2;

/**
 * Author:tangc
 * Date:2016/6/18
 * Time:17:09
 * DESCR:
 */
public class ActionAdapter implements Action {
    public void click() {
        System.out.println("哎哟！~你单击了我!");
    }

    public void dbclick() {
        System.out.println("哎哟！！~你双击了我！");
    }

    public void mouseOver() {
        System.out.println("啊啊啊啊！~你移到我身上了！~");
    }
}
