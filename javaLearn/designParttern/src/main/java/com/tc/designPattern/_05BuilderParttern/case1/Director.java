package com.tc.designPattern._05BuilderParttern.case1;

// 导演类
// 导演类起到封装的作用，避免高层模块深入到建造者内部的实现类。当然，在建造者模式比较庞大时，导演类可以有多个。
public class Director {

    private Builder builder = new ConcreteProduct();

    // 构件不同的的产品
    public Product getAProduct() {
        builder.setPart();
        Product product = builder.buildProduct();

        return product;
    }
}
