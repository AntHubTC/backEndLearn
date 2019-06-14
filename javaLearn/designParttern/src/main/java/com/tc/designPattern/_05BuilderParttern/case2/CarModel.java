package com.tc.designPattern._05BuilderParttern.case2;

import java.util.ArrayList;
import java.util.List;

// 车辆模型的抽象类   实现了模板方法模式
public abstract class CarModel {
    // 这个参数是各个基本方法执行的顺序
    private List<String> sequence = new ArrayList<>();

    // 模型是启动开始跑了
    protected abstract void start();

    // 能发动，还要能停下来，那才是真本事
    protected abstract void stop();

    // 喇叭会出声音，是滴滴叫，还是哔哔叫
    protected abstract void alarm();

    // 引擎会轰隆隆地响，不响那是假的
    protected abstract void engineBoom();

    // 那模型应该会跑吧，别管是人推的，还是电力驱动，总之要会跑
    final public void run() {
        for (String actionName : sequence) {
            switch (actionName) {
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "engine boom":
                    this.engineBoom();
                    break;
            }
        }
    }

    // 把传递过来的值传递到类内
    final public void setSequence(ArrayList sequence) {
        this.sequence = sequence;
    }
}
