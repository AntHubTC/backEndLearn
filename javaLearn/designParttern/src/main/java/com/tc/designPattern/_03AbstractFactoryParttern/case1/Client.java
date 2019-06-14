package com.tc.designPattern._03AbstractFactoryParttern.case1;

/**
 * 这个是抽象工厂的通用源码案例
 */
public class Client {
    public static void main(String[] args) {
        // 定义出两个工程
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        // 产生不同产品的对象
        AbstractProductA a1 = creator1.createProductA();
        AbstractProductB b1 = creator1.createProductB();
        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b2 = creator2.createProductB();

        /*
            然后到这里就可以为所欲为了...
         */
    }
}
