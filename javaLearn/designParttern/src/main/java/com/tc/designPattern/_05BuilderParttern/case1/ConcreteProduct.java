package com.tc.designPattern._05BuilderParttern.case1;

/**
 *  具体建造者
 *
 *  注意：如果有多个产品类就有几个具体的建造者，而且这多个产品类具有相同接口或抽象类。
 */
public class ConcreteProduct extends Builder {

    private Product product = new Product();

    // 设置产品零件
    @Override
    public void setPart() {

    }

    // 组件一个产品
    @Override
    public Product buildProduct() {

        return product;
    }
}
