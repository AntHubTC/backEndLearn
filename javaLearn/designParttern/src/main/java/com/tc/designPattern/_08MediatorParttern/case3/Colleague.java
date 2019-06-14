package com.tc.designPattern._08MediatorParttern.case3;

// 抽象同事类
public abstract class Colleague {
    protected Mediator mediator;
    public Colleague(Mediator _mediator){
        this.mediator = _mediator;
    }
}
