package com.tc.designPattern._08MediatorParttern.case2;

/**
 加入了一个中介者作为三个模块的交流核心，每个模块之间不再相互交流，要交流就通
 过中介者进行。每个模块只负责自己的业务逻辑，不属于自己的则丢给中介者来处理，简化
 了各模块之间的耦合关系，
 */
public abstract class AbstractMediator {
    // 参与者通过中介者交流
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;

    // 构造函数

    public AbstractMediator() {
        this.purchase = new Purchase(this);
        this.sale = new Sale(this);
        this.stock = new Stock(this);
    }

    // 中介者最重要的方法叫做事件方法，处理多个对象之间的关系
    public abstract void execute(String str, Object ...objects);
}
